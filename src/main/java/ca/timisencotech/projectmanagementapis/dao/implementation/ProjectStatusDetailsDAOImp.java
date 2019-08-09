package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectStatusDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectStatusDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectStatusDetailsDAOImp implements ProjectStatusDetailsDAO {
	
	@Autowired
	ProjectSupervisorsDetailsRepository projectSupervisorsDetailsRepository;
	
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;
	
	@Autowired
	ProjectStatusDetailsRepository projectStatusDetailsRepository;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectStatusDetails(ProjectStatusDetail projectStatusDetail) {
		Container<T> genericObject=null; 
	
		String description = projectStatusDetail.getDescription();
		String projectName = projectStatusDetail.getProjectName();
		Timestamp completedDate = projectStatusDetail.getCompletedDate();
		double donePercentage = projectStatusDetail.getDonePercentage();
		Timestamp updatedDate = projectStatusDetail.getUpdatedDate();
		try {
			
			ProjectDetails findProjectDetails = projectDetailsRepository.findProjectDetailsByProjectName(projectName);
			
			if(findProjectDetails!=null)
			{
				ProjectStatusDetails newProjectStatusDetails = new ProjectStatusDetails();
				
				newProjectStatusDetails.setCompletedDate(completedDate);
				newProjectStatusDetails.setDescription(description);
				newProjectStatusDetails.setDonePercentage(donePercentage);
				newProjectStatusDetails.setProjectDetails(findProjectDetails);
				newProjectStatusDetails.setUpdatedDate(updatedDate);
				
				ProjectStatusDetails responseProjectStatusDetails = projectStatusDetailsRepository.save(newProjectStatusDetails);
				ProjectStatusDetail domainProjectStatusDetail = new ProjectStatusDetail();
				domainProjectStatusDetail.setCompletedDate(responseProjectStatusDetails.getCompletedDate());
				domainProjectStatusDetail.setDescription(responseProjectStatusDetails.getDescription());
				domainProjectStatusDetail.setDonePercentage(responseProjectStatusDetails.getDonePercentage());
				domainProjectStatusDetail.setProjectName(projectName);
				domainProjectStatusDetail.setUpdatedDate(responseProjectStatusDetails.getUpdatedDate());
				
				
				Application.getLogger().info("addProjectStatusDetails method in ProjectStatusDetails DAO Implementation. At this point update to project status has successfully saved to the database. Return ProjectStatusDetails from repo is"+domainProjectStatusDetail);
				genericObject = (Container<T>) new Container<ProjectStatusDetail>(domainProjectStatusDetail,"Class Object");
				  
			
			}
			else
			{
		
				 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Repository returned null"),"Null Object");
			
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectStatusDetails method in ProjectStatusDetails DAO Implementation. At this point there is an error that has prevented saving new project status details to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
