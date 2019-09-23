package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.TaskStatusDAO;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.dto.TaskStatusDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.TaskStatusRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class TaskStatusDAOImp implements TaskStatusDAO {
	
	
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberRepo;
	
	@Autowired
	TaskStatusRepo taskStatusRepo;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addTaskStatus(TaskStatus taskStatus) {
		Container<T> genericObject=null; 
	
		String memberName = taskStatus.getMemberName();
		String description = taskStatus.getDescription();
		String projectName = taskStatus.getProjectName();
		Timestamp completedDate = taskStatus.getCompletedDate();
		double donePercentage =taskStatus.getDonePercentage();
		Timestamp updatedDate = taskStatus.getUpdatedDate();
		String taskName = taskStatus.getTaskName();
		
		try {
			                                                                                               
			TaskAssignedMembersDetails findTaskAssignedMembersDetails =taskAssignedMemberRepo.findTaskAssignedMember(projectName,memberName,taskName); 
					
			if(findTaskAssignedMembersDetails!=null)
			{
				TaskStatusDetails newProjectTaskStatusDetails = new TaskStatusDetails();
				
				newProjectTaskStatusDetails.setCompletedDate(completedDate);
				newProjectTaskStatusDetails.setDescription(description);
				newProjectTaskStatusDetails.setDonePercentage(donePercentage);
				newProjectTaskStatusDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
				newProjectTaskStatusDetails.setUpdatedDate(updatedDate);
				
			
				TaskStatusDetails responseProjectTaskStatusDetails = taskStatusRepo.save(newProjectTaskStatusDetails);
				TaskStatus domainProjectTaskStatus = new TaskStatus();
				domainProjectTaskStatus.setCompletedDate(responseProjectTaskStatusDetails.getCompletedDate());
				domainProjectTaskStatus.setDescription(responseProjectTaskStatusDetails.getDescription());
				domainProjectTaskStatus.setDonePercentage(responseProjectTaskStatusDetails.getDonePercentage());
				domainProjectTaskStatus.setMemberName(memberName);
				domainProjectTaskStatus.setProjectName(projectName);
				domainProjectTaskStatus.setTaskName(taskName);
				domainProjectTaskStatus.setUpdatedDate(updatedDate);
				
				Application.getLogger().info("addProjectTaskStatus method in ProjectTaskStatus DAO Implementation. At this point update to project task status has successfully saved to the database. Return ProjectTaskStatus from repo is"+domainProjectTaskStatus);
				genericObject = (Container<T>) new Container<TaskStatus>(domainProjectTaskStatus,"Class Object");
				  
			
			}
			else
			{
		
				 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Repository returned null"),"Null Object");
				 		Application.getLogger().info("addProjectTaskStatus method in ProjectTaskStatus DAO Implementation. At this point this user is not a project member");
						
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectTaskStatus method in ProjectTaskStatus DAO Implementation. At this point there is an error that has prevented saving new project task status to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
