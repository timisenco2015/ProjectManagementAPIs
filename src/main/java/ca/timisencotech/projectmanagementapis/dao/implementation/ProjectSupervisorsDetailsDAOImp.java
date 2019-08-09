package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectSupervisorsDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectSupervisorsDetailsDAOImp implements  ProjectSupervisorsDetailsDAO {
	
	@Autowired
	ProjectSupervisorsDetailsRepository projectSupervisorsDetailsRepository;
	
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectSupervisorsDetails(ProjectSupervisorsDetail projectSupervisorsDetail) {
		Container<T> genericObject=null; 
	
		String supervisorName = projectSupervisorsDetail.getSupervisorName();
		String projectName = projectSupervisorsDetail.getProjectName();
		boolean isActive = projectSupervisorsDetail.getIsActive();
		try {
			ProjectDetails findProjectDetails = projectDetailsRepository.findProjectDetailsByProjectName(projectName);
			UserSignUpDetails findUserSignUpDetails =  userSignUpDetailsRepository.findUserSignUpDetailsByEmail(supervisorName);
			if(findProjectDetails!=null && findUserSignUpDetails!=null)
			{
				ProjectSupervisorsDetails newProjectSupervisorsDetails = new ProjectSupervisorsDetails();
				newProjectSupervisorsDetails.setIsActive(isActive);
				newProjectSupervisorsDetails.setProjectDetails(findProjectDetails);
				newProjectSupervisorsDetails.setUserSignUpDetails(findUserSignUpDetails);
				ProjectSupervisorsDetails responseProjectSupervisorsDetails = projectSupervisorsDetailsRepository.save(newProjectSupervisorsDetails);
				ProjectSupervisorsDetail domainProjectSupervisorsDetail = new ProjectSupervisorsDetail();
				domainProjectSupervisorsDetail.setIsActive(responseProjectSupervisorsDetails.getIsActive());
				domainProjectSupervisorsDetail.setProjectName(projectName);
				domainProjectSupervisorsDetail.setSupervisorName(supervisorName);
				Application.getLogger().info("addProjectSupervisorsDetails method in ProjectSupervisorsDetails DAO Implementation. At this point new user has successful saved to the database. Return UserSignUpDetail from repo is"+domainProjectSupervisorsDetail);
				genericObject = (Container<T>) new Container<ProjectSupervisorsDetail>(domainProjectSupervisorsDetail,"Class Object");
				  
			
			}
			else
			{
				if(findProjectDetails==null)
				{
					genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this project name: "+projectSupervisorsDetail.getProjectName()+" in our database"),"Null Object");
					
				}
				
				if(findUserSignUpDetails==null) 
				{
					genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this supervisor name: "+projectSupervisorsDetail.getSupervisorName()+" in our database"),"Null Object");
					
				}
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectSupervisorsDetails method in ProjectSupervisorsDetails DAO Implementation. At this point there is an error that has prevented saving new project supervisor details to the database "+dataAccessException.getMessage());
				genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
