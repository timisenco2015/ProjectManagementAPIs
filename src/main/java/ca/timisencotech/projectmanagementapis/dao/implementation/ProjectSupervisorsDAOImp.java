package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectSupervisorsDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisors;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectSupervisorsDAOImp implements  ProjectSupervisorsDAO {
	
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	UserSignUpRepo userSignUpRepo;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectSupervisors(ProjectSupervisors projectSupervisors) {
		Container<T> genericObject=null; 
	
		String supervisorName = projectSupervisors.getSupervisorName();
		String projectName = projectSupervisors.getProjectName();
		boolean isActive = projectSupervisors.getIsActive();
		try {
			ProjectDetails findProjectDetails = projectRepo.findProjectDetailsByProjectName(projectName);
			UserSignUpDetails findUserSignUpDetails =  userSignUpRepo.findUserSignUpDetailsByEmail(supervisorName);
			if(findProjectDetails!=null && findUserSignUpDetails!=null)
			{
				ProjectSupervisorsDetails newProjectSupervisorsDetails = new ProjectSupervisorsDetails();
				newProjectSupervisorsDetails.setIsActive(isActive);
				newProjectSupervisorsDetails.setProjectDetails(findProjectDetails);
				newProjectSupervisorsDetails.setUserSignUpDetails(findUserSignUpDetails);
				ProjectSupervisorsDetails responseProjectSupervisorsDetails = projectSupervisorsRepo.save(newProjectSupervisorsDetails);
				ProjectSupervisors domainProjectSupervisors = new ProjectSupervisors();
				domainProjectSupervisors.setIsActive(responseProjectSupervisorsDetails.getIsActive());
				domainProjectSupervisors.setProjectName(projectName);
				domainProjectSupervisors.setSupervisorName(supervisorName);
				Application.getLogger().info("addProjectSupervisors method in ProjectSupervisors DAO Implementation. At this point new project supervisor has successful saved to the database. Return ProjectSupervisors from repo is"+domainProjectSupervisors);
				genericObject = (Container<T>) new Container<ProjectSupervisors>(domainProjectSupervisors,"Class Object");
				  
			
			}
			else
			{
				if(findProjectDetails==null)
				{
					Application.getLogger().info("addProjectSupervisors method in ProjectSupervisors DAO Implementation. Did not find project name "+projectName +" in the database");
					genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this project name: "+projectSupervisors.getProjectName()+" in our database"),"Null Object");
					
				}
				
				if(findUserSignUpDetails==null) 
				{
					Application.getLogger().info("addProjectSupervisors method in ProjectSupervisors DAO Implementation. Did not find supervisor name "+supervisorName +"in the database");
					
					genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this supervisor name: "+projectSupervisors.getSupervisorName()+" in our database"),"Null Object");
					
				}
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectSupervisors method in ProjectSupervisors DAO Implementation. At this point there is an error that has prevented saving new project supervisor to the database "+dataAccessException.getMessage());
				genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
