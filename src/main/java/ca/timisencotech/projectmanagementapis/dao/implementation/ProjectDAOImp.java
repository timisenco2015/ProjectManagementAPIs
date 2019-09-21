package ca.timisencotech.projectmanagementapis.dao.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectDAO;
import ca.timisencotech.projectmanagementapis.domain.Project;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectDAOImp implements ProjectDAO {
	
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectDetails(Project project) {
		Container<T> genericObject=null; 
			 try {
				 
				 String email = project.getCreatedBy();
				 UserSignUpDetails findUserSignUpDetails = userSignUpRepository.findUserSignUpDetailsByEmail(email);
				 
				 if(findUserSignUpDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+email+" in our database"),"Error Object");
						Application.getLogger().info("addProjectDetails method in ProjectDetails DAO Implementation. At this point unable to find foreign key email in the database");
						
					}
				 
				 else
				 {
					ProjectDetails newProjectDetails = new ProjectDetails();
					newProjectDetails.setProjectName(project.getProjectName());
					newProjectDetails.setCreatedDate(project.getCreatedDate());
					newProjectDetails.setStartDate(project.getStartDate());
					newProjectDetails.setEndDate(project.getEndDate());
					newProjectDetails.setDescription(project.getDescription());
					newProjectDetails.setUserSignUpDetails(findUserSignUpDetails);
					
					ProjectDetails responseProjectDetails = projectRepository.save(newProjectDetails);
				 
					Project doaminProject = new Project();
					doaminProject.setProjectName(responseProjectDetails.getProjectName());
					doaminProject.setCreatedDate(responseProjectDetails.getCreatedDate());
					doaminProject.setStartDate(responseProjectDetails.getStartDate());
					doaminProject.setEndDate(responseProjectDetails.getEndDate());
					doaminProject.setDescription(responseProjectDetails.getDescription());
					doaminProject.setCreatedBy(email);
					
					Application.getLogger().info("addProjectDetails method in ProjectDetails DAO Implementation. At this point new project has successful saved to the database. Return projectinformation from repo is"+doaminProject);
				 
				 genericObject = (Container<T>) new Container<Project>(doaminProject,"Class Object");
			    }
				 
				
			 }
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("aaddProjectDetails method in ProjectDetails DAO Implementation. At this point there is an error that has prevented saving new user to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> Container<T> updateProjectDetails(Project project) {
	
		Container<T> genericObject=null;
		int responseProjectDetail = projectRepository.updateProjectDetails(project.getCreatedDate(), project.getStartDate(), project.getEndDate(), project.getDescription(), project.getProjectName());
			
		 try { 
	
			 	if(responseProjectDetail>0)
			 	{
			 		
					 Application.getLogger().info("updateUserPassword method in ProjectDetails DAO Implementation. At this point user password has successfully been changed in the database. Return userdetails from repo is"+responseProjectDetail);
					 genericObject = (Container<T>) new Container<Project>(project,"Class Object");
				    
			 	}
			 	else
			 	{
			 		genericObject = (Container<T>) new  Container<ApiError> (new ApiError("Persistence Error", "Unable to update project details"),"Update Object");
			 	}
			 	
		 }
		 catch (DataAccessException dataAccessException) {
			 Application.getLogger().info("updateUserPassword method in ProjectDetails DAO Implementation. At this point there is an error that has prevented updating project details in the database");
			 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
	
		 
		 }
		
		 return genericObject;
	}

	
}
