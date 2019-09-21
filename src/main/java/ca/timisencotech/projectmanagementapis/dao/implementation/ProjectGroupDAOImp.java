package ca.timisencotech.projectmanagementapis.dao.implementation;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectGroupDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepository;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectGroupDAOImp implements  ProjectGroupDAO {
	
	@Autowired
	ProjectGroupRepository projectGroupRepository;
	
	@Autowired
	ProjectSupervisorsRepository projectSupervisorsRepository;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectGroupDetails(ProjectGroup projectGroup) {
		Container<T> genericObject=null; 
	
		String createdBy = projectGroup.getCreatedBy();
		String description = projectGroup.getDescription();
		String groupName = projectGroup.getGroupName();
		Timestamp createdDate = projectGroup.getCreatedDate();
		boolean isActive =projectGroup.getIsActive();
		String projectName = projectGroup.getProjectName();
		try {
			
			ProjectSupervisorsDetails findProjectSupervisorsDetails =  projectSupervisorsRepository.findProjectSupervisorByProjectAndSupervisorName(projectName,createdBy);
			if(findProjectSupervisorsDetails!=null)
			{
				ProjectGroupDetails newProjectGroupDetails = new ProjectGroupDetails();
				newProjectGroupDetails.setDescription(description);
				newProjectGroupDetails.setGroupCreatedDate(createdDate);
				newProjectGroupDetails.setGroupName(groupName);
				newProjectGroupDetails.setIsActive(isActive);
				newProjectGroupDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
				
				ProjectGroupDetails responseProjectGroupDetails = projectGroupRepository.save(newProjectGroupDetails);
				
				ProjectGroup domainProjectGroup = new ProjectGroup();
				domainProjectGroup.setCreatedBy(createdBy);
				domainProjectGroup.setCreatedDate(responseProjectGroupDetails.getGroupCreatedDate());
				domainProjectGroup.setDescription(responseProjectGroupDetails.getDescription());
				domainProjectGroup.setGroupName(responseProjectGroupDetails.getGroupName());
				domainProjectGroup.setIsActive(responseProjectGroupDetails.getIsActive());
				domainProjectGroup.setProjectName(projectName);
				
				Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point new project group has successfully saved to the database. Return ProjectGroupDetail from repo is"+domainProjectGroup);
				genericObject = (Container<T>) new Container<ProjectGroup>(domainProjectGroup,"Class Object");
				  
			
			}
			
			else if(findProjectSupervisorsDetails==null)
				{
					
				 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this supervisor name: "+projectGroup.getProjectName()+" in our database"),"Null Object");
						Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point unable to find foreign key projectName in the database");
						
				}
			
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectGroupDetails method in ProjectGroupDetails DAO Implementation. At this point there is an error that has prevented saving new project group details to the database error details "+dataAccessException.getMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
