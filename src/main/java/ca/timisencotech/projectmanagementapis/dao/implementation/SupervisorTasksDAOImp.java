package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.SupervisorTasksDAO;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class SupervisorTasksDAOImp implements SupervisorTasksDAO {
	
	@Autowired
	SupervisorTasksRepository supervisorTasksRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorTask(SupervisorTasks supervisorTasks) {
		Container<T> genericObject=null; 
		
		String taskName = supervisorTasks.getTaskName();
		String projectName=supervisorTasks.getProjectName();
		String supervisorName =supervisorTasks.getSupervisorName();
	TaskDetails findTaskDetails = taskRepository.findByTaskNameAndProjectName(projectName,taskName);
		
	ProjectSupervisorsDetails findProjectSupervisors =  projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName(projectName, supervisorName);
		
		
		if(findTaskDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" taskName:"+taskName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorTask method in SupervisorTasksDetails DAO Implementation. Can't find taskdetails using projectName and taskName");
			
		}
		if(findProjectSupervisors==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" supervisor name:"+supervisorName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorTask method in SupervisorTasksDetails DAO Implementation. It seems that you are not a supervisor for this project yet");
			
		}
		else
		{
		
			SupervisorTasksDetails newSupervisorTasksDetails = new SupervisorTasksDetails();
			newSupervisorTasksDetails.setProjectSupervisorsDetails(findProjectSupervisors);
			newSupervisorTasksDetails.setTaskDetails(findTaskDetails);
			
			try {
				 
				SupervisorTasksDetails responseSupervisorTasksDetails = supervisorTasksRepository.save(newSupervisorTasksDetails);
				SupervisorTasks domainSupervisorTasks = new SupervisorTasks();
				domainSupervisorTasks.setProjectName(projectName); 
				domainSupervisorTasks.setSupervisorName(supervisorName);
				domainSupervisorTasks.setTaskName(taskName);
				
				Application.getLogger().info("addSupervisorTask method in SupervisorTasksDetails DAO Implementation. At this point this task has been added to the supervisor task list and has successful saved to the database. Return supervisor tasks from repo is"+domainSupervisorTasks);
					 
				  genericObject = (Container<T>) new Container<SupervisorTasks>(domainSupervisorTasks,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addSupervisorTask method in SupervisorTasksDetails DAO Implementation. At this point there is an error that as prevented assigning this task to the supervisor task list and saving it to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}
