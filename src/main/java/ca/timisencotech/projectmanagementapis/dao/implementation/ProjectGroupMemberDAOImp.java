package ca.timisencotech.projectmanagementapis.dao.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.ProjectGroupMemberDAO;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.UserSignUpDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.UserSignUpRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class ProjectGroupMemberDAOImp implements  ProjectGroupMemberDAO {
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
	@Autowired
	ProjectGroupRepo projectGroupRepo;
	
	@Autowired
	UserSignUpRepo userSignUpRepo;

	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addMemberToProjectGroup(ProjectGroupMembers projectGroupMembers) {
		Container<T> genericObject=null; 
		String groupName = projectGroupMembers.getGroupName();
		boolean isActive = projectGroupMembers.getIsActive();
		String memberName =projectGroupMembers.getMemberName();
		String projectName = projectGroupMembers.getProjectName();
		String activitiesUpdate = projectGroupMembers.getActivitiesUpdate();
		try {
			
			ProjectGroupMemberDetails findProjectGroupMemberDetails = projectGroupMemberRepo.findProjectMemberByProjectname(projectName, memberName);
			
			if(findProjectGroupMemberDetails==null || findProjectGroupMemberDetails.getProjectGroupDetails().getGroupName().equalsIgnoreCase(groupName))
			{
				
				ProjectGroupDetails findProjectGroupDetails =	projectGroupRepo.findProjectGroupDetailsByGroupName( projectName, groupName);		
				UserSignUpDetails findUserSignUpDetails = userSignUpRepo.findUserSignUpDetailsByEmail(memberName);
				if(findProjectGroupDetails!=null && findUserSignUpDetails!=null)
				{
					ProjectGroupMemberDetails newProjectGroupMemberDetails =new ProjectGroupMemberDetails();
					newProjectGroupMemberDetails.setIsActive(isActive);
					newProjectGroupMemberDetails.setProjectGroupDetails(findProjectGroupDetails);
					newProjectGroupMemberDetails.setUserSignUpDetails(findUserSignUpDetails);
					newProjectGroupMemberDetails.setActivitiesUpdate(activitiesUpdate);
					ProjectGroupMemberDetails responseProjectGroupMemberDetails = projectGroupMemberRepo.save(newProjectGroupMemberDetails);
					ProjectGroupMembers domainProjectGroupMember = new ProjectGroupMembers();
					domainProjectGroupMember.setGroupName(groupName);
					domainProjectGroupMember.setIsActive(responseProjectGroupMemberDetails.getIsActive());
					domainProjectGroupMember.setMemberName(memberName);
					domainProjectGroupMember.setProjectName(projectName);
					domainProjectGroupMember.setActivitiesUpdate(responseProjectGroupMemberDetails.getActivitiesUpdate());
					Application.getLogger().info("addProjectGroupMember method in ProjectGroupMember DAO Implementation. At this point new member has been added to the project group and successfully saved to the database. Return ProjectGroupMemberDetails from repo is"+domainProjectGroupMember);
					genericObject = (Container<T>) new Container<ProjectGroupMembers>(domainProjectGroupMember,"Class Object");
				}
				
				else
				{
					if(findProjectGroupMemberDetails==null)
					{
					 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this project name: "+projectName+" in our database"),"Null Object");
							Application.getLogger().info("addProjectGroupMemberDetails method in ProjectGroupMember DAO Implementation. At this point unable to find foreign key projectName in the database");	
					}
					
					if(findUserSignUpDetails==null) 
					{
						
					 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have this user email: "+memberName+" in our database"),"Null Object");
							Application.getLogger().info("addProjectGroupMember method in ProjectGroupMember DAO Implementation. At this point unable to find foreign key email in the database");
							
					}
				}			
			}
			else
			{
		 		genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("Member can only belong one project group"),"Unique Object");
				Application.getLogger().info("addProjectGroupMember method in ProjectGroupMember DAO Implementation. At this point member already belong to a project group"
						+ "");	
		
			}
		} 
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("addMemberToProjectGroup method in ProjectGroupMember DAO Implementation. At this point there is an error that has prevented saving new project group member to the database error details "+dataAccessException.getLocalizedMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");		 
			 }
		return genericObject;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> changeProjectMemberGroup(ProjectGroupMembers projectGroupMembers) {
		Container<T> genericObject=null; 
		String groupName = projectGroupMembers.getGroupName();
		String memberName =projectGroupMembers.getMemberName();
		String projectName = projectGroupMembers.getProjectName();
			
try {
			
			int updated =   projectGroupMemberRepo.updateProjectMemberGroup(groupName, projectName, memberName);
			if(updated>0)
			{
				Application.getLogger().info("changeProjectMemberGroup method in ProjectGroupMember DAO Implementation. At this point member project group has been changed and successfully saved to the database. Return ProjectGroupMember from repo is"+projectGroupMembers);
				genericObject = (Container<T>) new Container<ProjectGroupMembers>(projectGroupMembers,"Class Object");
			
			}
}
			 catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("changeProjectMemberGroup method in ProjectGroupMember DAO Implementation. At this point there is an error that has prevented changing member project group and saving it to the database. error details "+dataAccessException.getMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");		 
			 }	
		
		return genericObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> removeMemberFromProjectGroup(ProjectGroupMembers projectGroupMembers) {
		Container<T> genericObject=null; 
		boolean isActive = projectGroupMembers.getIsActive();
		String memberName =projectGroupMembers.getMemberName();
		String projectName = projectGroupMembers.getProjectName();
	
		
		
		try {
			
			int updated =   projectGroupMemberRepo.deleteProjectGroupMember(isActive,projectName, memberName);
			if(updated>0)
			{
				Application.getLogger().info("removeMemberFromProjectGroup method in ProjectGroupMember DAO Implementation. At this point member has been removed from  project group member and has been successfully saved to the database. Return ProjectGroupMember from repo is"+projectGroupMembers);
				genericObject = (Container<T>) new Container<ProjectGroupMembers>(projectGroupMembers,"Class Object");
			
			}
		
		}	
			
			catch (DataAccessException dataAccessException) {
				 Application.getLogger().info("removeMemberFromProjectGroup method in ProjectGroupMember DAO Implementation. At this point there is an error that has prevented removing member from project group. error details "+dataAccessException.getMessage());
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");		 
			 }	
		return genericObject;
	}
	
		
	
}
