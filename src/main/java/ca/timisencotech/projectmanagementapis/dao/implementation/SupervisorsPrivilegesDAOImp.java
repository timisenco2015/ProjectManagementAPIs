package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.SupervisorsPrivilegesDAO;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.dto.Privileges;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsPrivilegesDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorsPrivilegesRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class SupervisorsPrivilegesDAOImp implements SupervisorsPrivilegesDAO {
	
	@Autowired
	SupervisorsPrivilegesRepo supervisorsPrivilegesRepo;
	
	@Autowired
	ProjectSupervisorsRepo projectSupervisorsRepo;
	
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorsPrivileges(SupervisorsPrivileges supervisorsPrivileges) {
		Container<T> genericObject=null; 
		
		
		String projectName = supervisorsPrivileges.getProjectName();
		Privileges privileges = supervisorsPrivileges.getPrivileges();
		String supervisorName = supervisorsPrivileges.getSupervisorName();
		
		ProjectSupervisorsDetails findProjectSupervisorsDetails = projectSupervisorsRepo.findProjectSupervisorByProjectAndSupervisorName(projectName,supervisorName);
		
		if(findProjectSupervisorsDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("this user:"+supervisorName+" is not a supervisor on any project"),"Error Object");
			Application.getLogger().info("addSupervisorsPrivileges method in SupervisorsPrivileges DAO Implementation. It seems that you are not a supervisor to any project yet");
			
		}
	
		else
		{
		
			SupervisorsPrivilegesDetails newSupervisorsPrivilegesDetails = new SupervisorsPrivilegesDetails();
			newSupervisorsPrivilegesDetails.setPrivileges(privileges);
			newSupervisorsPrivilegesDetails.setProjectSupervisorsDetails(findProjectSupervisorsDetails);
			
			try {
				 
				SupervisorsPrivilegesDetails responseSupervisorsPrivilegesDetails = supervisorsPrivilegesRepo.save(newSupervisorsPrivilegesDetails);
				SupervisorsPrivileges domainSupervisorsPrivileges = new SupervisorsPrivileges();
				domainSupervisorsPrivileges.setProjectName(projectName);;
				domainSupervisorsPrivileges.setSupervisorName(supervisorName);;
				domainSupervisorsPrivileges.setPrivileges(responseSupervisorsPrivilegesDetails.getPrivileges());
				 Application.getLogger().info("addSupervisorsPrivileges method in SupervisorsPrivilegesDetails DAO Implementation. At this point supervisor privileges has been set has successful saved to the database. Return supervisor privileges from repo is"+domainSupervisorsPrivileges);
					 
				  genericObject = (Container<T>) new Container<SupervisorsPrivileges>(domainSupervisorsPrivileges,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addSupervisorsPrivileges method in SupervisorsPrivilegesDetails DAO Implementation. At this point there is an error that as prevented setting supervisor privileges and saving it to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}
