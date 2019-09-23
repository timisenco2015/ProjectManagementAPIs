package ca.timisencotech.projectmanagementapis.dao.implementation;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.TaskAssignedMembersDAO;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class TaskAssignedMembersDAOImp implements TaskAssignedMembersDAO {
	
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
	@Autowired
	SupervisorTasksRepo supervisorTasksRepo;
	
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberRepo;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> assignedTaskToMembers(TaskAssignedMembers taskAssignedMembers) {
		Container<T> genericObject=null; 
			 try {
				 
				 
				String supervisorName = taskAssignedMembers.getAssignedBy();
				String memberName=taskAssignedMembers.getAssignedTo();
				Timestamp dateAssigned	= taskAssignedMembers.getDateAssigned();
				String description =		taskAssignedMembers.getDescription();
				String projectName=		taskAssignedMembers.getProjectName();
				String taskName = taskAssignedMembers.getTaskName();
				boolean isActive = taskAssignedMembers.getIsActive();
				
				
				SupervisorTasksDetails findSupervisorTasksDetails= supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName(projectName, supervisorName, taskName);
				 ProjectGroupMemberDetails findProjectGroupMemberDetails= projectGroupMemberRepo.findProjectMemberByProjectname(projectName,memberName);
				 if(findSupervisorTasksDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user supervisor name: "+supervisorName+" in supervisor list for the project name "+projectName),"Error Object");
						Application.getLogger().info("assignedTaskToMemberss method in TaskAssignedMembers DAO Implementation. At this point unable to find supervisor email in the supervisor list for this project in the database");
						
					}
				 if(findProjectGroupMemberDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have combination of this project name: "+projectName+" and memberName:"+memberName+" in our project members table"),"Error Object");
						Application.getLogger().info("assignedTaskToMembers method in TaskAssignedMembers DAO Implementation. At this point unable to find member based on the projectname and membername provided");
						
					}
				 
				 else
				 {
					
					 TaskAssignedMembersDetails newTaskAssignedMembersDetails = new TaskAssignedMembersDetails();
					 newTaskAssignedMembersDetails.setDateAssigned(dateAssigned);
					 newTaskAssignedMembersDetails.setDescription(description);
					 newTaskAssignedMembersDetails.setIsActive(isActive);
					 newTaskAssignedMembersDetails.setProjectGroupMemberDetails(findProjectGroupMemberDetails);
					 newTaskAssignedMembersDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
					 
					 
					 TaskAssignedMembersDetails responseTaskAssignedMembersDetails = taskAssignedMemberRepo.save(newTaskAssignedMembersDetails);
				
					 TaskAssignedMembers domainTaskAssignedMembers = new TaskAssignedMembers();
					 domainTaskAssignedMembers.setActive(isActive);
					 domainTaskAssignedMembers.setAssignedBy(supervisorName);
					 domainTaskAssignedMembers.setAssignedTo(memberName);
					 domainTaskAssignedMembers.setDateAssigned(responseTaskAssignedMembersDetails.getDateAssigned());
					 domainTaskAssignedMembers.setDescription(responseTaskAssignedMembersDetails.getDescription());
					 domainTaskAssignedMembers.setProjectName(projectName);
					 domainTaskAssignedMembers.setTaskName(taskName);
					
					 Application.getLogger().info("assignedTaskToMembers method in TaskAssignedMembers DAO Implementation. At this point new task has assigned to member and successful saved to the database. Return TaskAssignedMembersDetails from repo is"+domainTaskAssignedMembers);
				 
				 genericObject = (Container<T>) new Container<TaskAssignedMembers>(domainTaskAssignedMembers,"Class Object");
			    }
				 
				
				 
			 }
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("assignedTaskToMembers method in TaskAssignedMembers DAO Implementation. At this point there is an error that has prevented assigning task to members and saving it to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
}
