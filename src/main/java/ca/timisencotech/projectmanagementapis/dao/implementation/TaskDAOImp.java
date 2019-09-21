package ca.timisencotech.projectmanagementapis.dao.implementation;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.TaskDAO;
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepository;
import ca.timisencotech.projectmanagementapis.repository.TaskRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class TaskDAOImp implements TaskDAO {
	
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addTaskDetails(Task task) {
		Container<T> genericObject=null; 
			 try {
				 
				 String createdBy = task.getCreatedBy();
				 String projectName = task.getProjectName();
				 String taskName = task.getTaskName();
				 String description = task.getDescription();
				 Timestamp createdDate = task.getCreatedDate();
				Timestamp endDate = task.getEndDate();
				Timestamp startDate = task.getStartDate();
				
				ProjectDetails findProjectDetails= projectRepository.findProjectDetailsByProjectName (projectName);
				 UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail(createdBy);
				 
				 if(findUserSignUpDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+createdBy+" in our database"),"Error Object");
						Application.getLogger().info("addTaskDetails method in ProjectDetails DAO Implementation. At this point unable to find foreign key email in the database");
						
					}
				 if(findProjectDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this project name: "+projectName+" in our database"),"Error Object");
						Application.getLogger().info("addTaskDetails method in TaskDetails DAO Implementation. At this point unable to find foreign key projectname in the database");
						
					}
				 
				 else
				 {
					
					TaskDetails newTaskDetails = new TaskDetails();
					newTaskDetails.setCreatedDate(createdDate);
					newTaskDetails.setDescription(description);
					newTaskDetails.setEndDate(endDate);
					newTaskDetails.setProjectDetails(findProjectDetails);
					newTaskDetails.setStartDate(startDate);
					newTaskDetails.setTaskName(taskName);
					newTaskDetails.setUserSignUpDetails(findUserSignUpDetails);
					
				
					TaskDetails responseTaskDetails = taskRepository.save(newTaskDetails);
				 
					Task domainTask = new Task();
					
					domainTask.setCreatedBy(createdBy);
					domainTask.setCreatedDate(responseTaskDetails.getCreatedDate());
					domainTask.setDescription(responseTaskDetails.getDescription());
					domainTask.setEndDate(responseTaskDetails.getEndDate());
					domainTask.setProjectName(projectName);
					domainTask.setStartDate(responseTaskDetails.getStartDate());
					domainTask.setTaskName(responseTaskDetails.getTaskName());
					
					
					Application.getLogger().info("addTaskDetails method in TaskDetails DAO Implementation. At this point new task has successful saved to the database. Return TaskDetails from repo is"+domainTask);
				 
				 genericObject = (Container<T>) new Container<Task>(domainTask,"Class Object");
			    }
				 
				
			 }
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addTaskDetails method in TaskDetails DAO Implementation. At this point there is an error that has prevented saving new task to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> Container<T> updateTaskDetails(Task task) {
	
		Container<T> genericObject=null;
		
		int responseTaskDetail = taskRepository.updateTaskDetails(task.getCreatedDate(), task.getStartDate(), task.getEndDate(), task.getDescription(), task.getCreatedBy(), task.getProjectName());
				
		 try { 
	
			 	if(responseTaskDetail>0)
			 	{
			 		
					 Application.getLogger().info("updateTaskDetails method in TaskDetails DAO Implementation. At this point task details has successfully been changed in the database. Returntaskdetails from repo is"+responseTaskDetail);
					 genericObject = (Container<T>) new Container<Task>(task,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Unable to update project details"),"Update Object");
			 	}
			 	
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("updateTaskDetails method in TaskDetails DAO Implementation. At this point there is an error that has prevented updating task details in the database");
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		
		 return genericObject;
	}

	
}
