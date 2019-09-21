package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectStatusDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectStatusRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectStatusDAOImp implements ProjectStatusDAO {
	
	
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	@Autowired
	ProjectStatusRepository projectStatusRepository;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectStatusDetails(ProjectStatus projectStatus) {
		Container<T> genericObject=null; 
	
		String supervisorName = projectStatus.getSupervisorName();
		String description = projectStatus.getDescription();
		String projectName = projectStatus.getProjectName();
		Timestamp completedDate = projectStatus.getCompletedDate();
		double donePercentage = projectStatus.getDonePercentage();
		Timestamp updatedDate = projectStatus.getUpdatedDate();
		try {
			
			ProjectSupervisorsDetails findProjectSupervisorsDetails =projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName(projectName, supervisorName); 
			if(findProjectSupervisorsDetails!=null)
			{
				ProjectStatusDetails newProjectStatusDetails = new ProjectStatusDetails();
				
				newProjectStatusDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				newProjectStatusDetails.setCompletedDate(completedDate);
				newProjectStatusDetails.setDescription(description);
				newProjectStatusDetails.setDonePercentage(donePercentage);
				newProjectStatusDetails.setUpdatedDate(updatedDate);
				
				ProjectStatusDetails responseProjectStatusDetails = projectStatusRepository.save(newProjectStatusDetails);
				ProjectStatus domainProjectStatus = new ProjectStatus();
				domainProjectStatus.setCompletedDate(responseProjectStatusDetails.getCompletedDate());
				domainProjectStatus.setDescription(responseProjectStatusDetails.getDescription());
				domainProjectStatus.setDonePercentage(responseProjectStatusDetails.getDonePercentage());
				domainProjectStatus.setProjectName(projectName);
				domainProjectStatus.setUpdatedDate(responseProjectStatusDetails.getUpdatedDate());
				
				
				Application.getLogger().info("addProjectStatusDetails method in ProjectStatusDetails DAO Implementation. At this point update to project status has successfully saved to the database. Return ProjectStatusDetails from repo is"+domainProjectStatus);
				genericObject = (Container<T>) new Container<ProjectStatus>(domainProjectStatus,"Class Object");
				  
			
			}
			else
			{
		
				 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Repository returned null"),"Null Object");
			
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectStatusDetails method in ProjectStatusDetails DAO Implementation. At this point there is an error that has prevented saving new project status details to the database --> "+dataAccessException.getLocalizedMessage());
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
