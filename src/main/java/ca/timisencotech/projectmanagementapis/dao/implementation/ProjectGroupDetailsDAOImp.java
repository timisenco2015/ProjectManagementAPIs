package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectGroupDetailsDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupDetailsRepository;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpDetailsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectGroupDetailsDAOImp implements  ProjectGroupDetailsDAO {
	
	@Autowired
	ProjectGroupDetailsRepository projectGroupDetailsRepository;
	
	@Autowired
	ProjectDetailsRepository projectDetailsRepository;
	
	@Autowired
	UserSignUpDetailsRepository userSignUpDetailsRepository;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectGroupDetails(ProjectGroupDetail projectGroupDetail) {
		Container<T> genericObject=null; 
	
		String createdBy = projectGroupDetail.getCreatedBy();
		String description = projectGroupDetail.getDescription();
		String groupName = projectGroupDetail.getGroupName();
		Timestamp createdDate = projectGroupDetail.getCreatedDate();
		boolean isActive =projectGroupDetail.getIsActive();
		String projectName = projectGroupDetail.getProjectName();
		try {
			
			ProjectDetails findProjectDetails = projectDetailsRepository.findProjectDetailsByProjectName(projectName);
			UserSignUpDetails findUserSignUpDetails =  userSignUpDetailsRepository.findUserSignUpDetailsByEmail(createdBy);
			if(findProjectDetails!=null && findUserSignUpDetails!=null)
			{
				ProjectGroupDetails newProjectGroupDetails = new ProjectGroupDetails();
				newProjectGroupDetails.setDescription(description);
				newProjectGroupDetails.setGroupCreatedDate(createdDate);
				newProjectGroupDetails.setGroupName(groupName);
				newProjectGroupDetails.setIsActive(isActive);
				newProjectGroupDetails.setProjectDetails(findProjectDetails);
				newProjectGroupDetails.setUserSignUpDetails(findUserSignUpDetails);
				 	
				ProjectGroupDetails responseProjectGroupDetails = projectGroupDetailsRepository.save(newProjectGroupDetails);
				ProjectGroupDetail domainProjectGroupDetail = new ProjectGroupDetail();
				domainProjectGroupDetail.setCreatedBy(createdBy);
				domainProjectGroupDetail.setCreatedDate(responseProjectGroupDetails.getGroupCreatedDate());
				domainProjectGroupDetail.setDescription(responseProjectGroupDetails.getDescription());
				domainProjectGroupDetail.setGroupName(responseProjectGroupDetails.getGroupName());
				domainProjectGroupDetail.setIsActive(responseProjectGroupDetails.getIsActive());
				domainProjectGroupDetail.setProjectName(projectName);
				
				Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point new project group has successfully saved to the database. Return ProjectGroupDetail from repo is"+domainProjectGroupDetail);
				genericObject = (Container<T>) new Container<ProjectGroupDetail>(domainProjectGroupDetail,"Class Object");
				  
			
			}
			else
			{
				if(findProjectDetails==null)
				{
					
				 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this project name: "+projectGroupDetail.getProjectName()+" in our database"),"Null Object");
						Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point unable to find foreign key projectName in the database");
						
				}
				
				if(findUserSignUpDetails==null) 
				{
					
				 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+projectGroupDetail.getCreatedBy()+" in our database"),"Null Object");
						Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point unable to find foreign key email in the database");
						
				}
			}
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point there is an error that has prevented saving new project group details to the database error details "+dataAccessException.getMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
