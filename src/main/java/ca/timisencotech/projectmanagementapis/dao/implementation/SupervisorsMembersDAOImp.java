package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.SupervisorsMembersDAO;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsMembersDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectGroupMemberRepo;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorsMembersRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class SupervisorsMembersDAOImp implements SupervisorsMembersDAO {
	
	@Autowired
	SupervisorsMembersRepo supervisorsMembersRepo;
	
	@Autowired
	ProjectGroupMemberRepo projectGroupMemberRepo;
	
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorMember(SupervisorsMembers supervisorsMembers) {
		Container<T> genericObject=null; 
		
		
		String projectName = supervisorsMembers.getProjectName();
		String memberName = supervisorsMembers.getMemberName();
		String supervisorName = supervisorsMembers.getSupervisorName();
		
		
		ProjectGroupMemberDetails findProjectGroupMember = projectGroupMemberRepo.findProjectMemberByProjectname(projectName, memberName);
		ProjectSupervisorsDetails findProjectSupervisors =  projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName(projectName, supervisorName);
		
	
		if(findProjectGroupMember==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" member name:"+memberName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorMember method in SupervisorsMembersDetails DAO Implementation. It seems that you are a member of this project yet");
			
		}
		if(findProjectSupervisors==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" supervisor name:"+supervisorName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorMember method in SupervisorsMembersDetails DAO Implementation. It seems that you are not a supervisor for this project yet");
			
		}
		else
		{
		
			SupervisorsMembersDetails newSupervisorsMembersDetails = new SupervisorsMembersDetails();
			newSupervisorsMembersDetails.setProjectGroupMemberDetails(findProjectGroupMember);
			newSupervisorsMembersDetails.setProjectSupervisorsDetails(findProjectSupervisors);
			 try {
				 
				 SupervisorsMembersDetails responseSupervisorsMembersDetails = supervisorsMembersRepo.save(newSupervisorsMembersDetails);
				 SupervisorsMembers domainSupervisorsMembers = new SupervisorsMembers();
				 domainSupervisorsMembers.setMemberName(memberName);
				 domainSupervisorsMembers.setProjectName(projectName);
				 domainSupervisorsMembers.setSupervisorName(supervisorName);
				 Application.getLogger().info("addSupervisorMember method in SupervisorsMembersDetails DAO Implementation. At this point this member is now the supervisor member and has successful saved to the database. Return supervisor appraisal from repo is"+domainSupervisorsMembers);
					 
				  genericObject = (Container<T>) new Container<SupervisorsMembers>(domainSupervisorsMembers,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addSupervisorMember method in SupervisorsMembersDetails DAO Implementation. At this point there is an error that as prevented adding this member to the supervisor member list and saving it to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}
