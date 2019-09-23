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
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectGroupDAOImp implements  ProjectGroupDAO {
	
	@Autowired
	ProjectGroupRepo projectGroupRepo;
	
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addProjectGroup(ProjectGroup projectGroup) {
		Container<T> genericObject=null; 
	
		String createdBy = projectGroup.getCreatedBy();
		String description = projectGroup.getDescription();
		String groupName = projectGroup.getGroupName();
		Timestamp createdDate = projectGroup.getCreatedDate();
		boolean isActive =projectGroup.getIsActive();
		String projectName = projectGroup.getProjectName();
		try {
			
			ProjectSupervisorsDetails findProjectSupervisors =  projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName(projectName,createdBy);
			if(findProjectSupervisors!=null)
			{
				ProjectGroupDetails newProjectGroup = new ProjectGroupDetails();
				newProjectGroup.setDescription(description);
				newProjectGroup.setGroupCreatedDate(createdDate);
				newProjectGroup.setGroupName(groupName);
				newProjectGroup.setIsActive(isActive);
				newProjectGroup.setProjectSupervisorsDetails(findProjectSupervisors);
				
				ProjectGroupDetails responseProjectGroup = projectGroupRepo.save(newProjectGroup);
				
				ProjectGroup domainProjectGroup = new ProjectGroup();
				domainProjectGroup.setCreatedBy(createdBy);
				domainProjectGroup.setCreatedDate(responseProjectGroup.getGroupCreatedDate());
				domainProjectGroup.setDescription(responseProjectGroup.getDescription());
				domainProjectGroup.setGroupName(responseProjectGroup.getGroupName());
				domainProjectGroup.setIsActive(responseProjectGroup.getIsActive());
				domainProjectGroup.setProjectName(projectName);
				
				Application.getLogger().info("addProjectGroup method in ProjectGroup DAO Implementation. At this point new project group has successfully saved to the database. Return ProjectGroup from repo is"+domainProjectGroup);
				genericObject = (Container<T>) new Container<ProjectGroup>(domainProjectGroup,"Class Object");
				  
			
			}
			
			else if(findProjectSupervisors==null)
				{
					
				 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this supervisor name: "+projectGroup.getProjectName()+" in our database"),"Null Object");
						Application.getLogger().info("addProjectGroup method in ProjectGroup DAO Implementation. At this point unable to find foreign key projectName in the database");
						
				}
			
			 
		}
			 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addProjectGroup method in ProjectGroup DAO Implementation. At this point there is an error that has prevented saving new project group to the database error details "+dataAccessException.getMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		
		
		return genericObject;
	}
	
	
	
		
	
}
