package ca.timisencotech.projectmanagementapis.dao.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectDetailsDAOImp implements ProjectDetailsDAO {
	
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;
	
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectDetails(ProjectInformation projectInformation) {
		Container<T> genericObject=null; 
			 try {
				 
				 String email = projectInformation.getCreatedBy();
				 UserSignUpDetails findUserSignUpDetails = userSignUpDetailsRepository.findUserSignUpDetailsByEmail(email);
				 
				 if(findUserSignUpDetails==null)
					{
						genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+email+" in our database"),"Error Object");
						Application.getLogger().info("addProjectDetails method in ProjectDetails DAO Implementation. At this point unable to find foreign key email in the database");
						
					}
				 
				 else
				 {
					ProjectDetails newProjectDetails = new ProjectDetails();
					newProjectDetails.setProjectName(projectInformation.getProjectName());
					newProjectDetails.setCreatedDate(projectInformation.getCreatedDate());
					newProjectDetails.setStartDate(projectInformation.getStartDate());
					newProjectDetails.setEndDate(projectInformation.getEndDate());
					newProjectDetails.setDescription(projectInformation.getDescription());
					newProjectDetails.setUserSignUpDetails(findUserSignUpDetails);
					
					ProjectDetails responseProjectDetails = projectDetailsRepository.save(newProjectDetails);
				 
					ProjectInformation domainprojectInformation = new ProjectInformation();
					domainprojectInformation.setProjectName(responseProjectDetails.getProjectName());
					domainprojectInformation.setCreatedDate(responseProjectDetails.getCreatedDate());
					domainprojectInformation.setStartDate(responseProjectDetails.getStartDate());
					domainprojectInformation.setEndDate(responseProjectDetails.getEndDate());
					domainprojectInformation.setDescription(responseProjectDetails.getDescription());
					domainprojectInformation.setCreatedBy(email);
					
					Application.getLogger().info("addProjectDetails method in ProjectDetails DAO Implementation. At this point new project has successful saved to the database. Return projectinformation from repo is"+domainprojectInformation);
				 
				 genericObject = (Container<T>) new Container<ProjectInformation>(domainprojectInformation,"Class Object");
			    }
				 
				
			 }
			 
		
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("aaddProjectDetails method in ProjectDetails DAO Implementation. At this point there is an error that has prevented saving new user to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
}
