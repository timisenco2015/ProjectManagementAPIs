package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.SupervisorAppraisalsDAO;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.dto.SupervisorAppraisalsDetails;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.SupervisorAppraisalsRepo;
import ca.timisencotech.projectmanagementapis.repository.SupervisorTasksRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class SupervisorAppraisalsDAOImp implements SupervisorAppraisalsDAO {
	
	@Autowired
	SupervisorAppraisalsRepo supervisorAppraisalsRepo;
	
	@Autowired
	SupervisorTasksRepo supervisorTasksRepo;
	
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberDetailsRepo;
	
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSupervisorAppraisals(SupervisorAppraisals supervisorAppraisals) {
		Container<T> genericObject=null; 
		
		
		String projectName = supervisorAppraisals.getProjectName();
		String memberName = supervisorAppraisals.getSubordinateMember();
		String taskName = supervisorAppraisals.getTaskName();
		String supervisorName = supervisorAppraisals.getSupervisorName();
		SupervisorTasksDetails findSupervisorTasksDetails = supervisorTasksRepo.findSupervisorsByProjectnameAndSupervisorNameAndTaskName(projectName, supervisorName, taskName); 
		TaskAssignedMembersDetails findTaskAssignedMembersDetails = taskAssignedMemberDetailsRepo.findTaskAssignedMember(projectName,memberName,taskName); 
		                         
		if(findTaskAssignedMembersDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" member name:"+memberName+"task name:"+taskName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorAppraisals method in SupervisorAppraisalsDetails DAO Implementation. It seems that you have not been assigned to this task yet");
			
		}
		if(findSupervisorTasksDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" supervisor name:"+supervisorName+"task name:"+taskName+" in our database"),"Error Object");
			Application.getLogger().info("addSupervisorAppraisals method in SupervisorAppraisalsDetails DAO Implementation. It seems that you are not a supervisor for this task yet");
			
		}
		else
		{
		
		SupervisorAppraisalsDetails newSupervisorAppraisalsDetails = new SupervisorAppraisalsDetails();
		newSupervisorAppraisalsDetails.setStandardA(supervisorAppraisals.getStandardA());
		newSupervisorAppraisalsDetails.setStandardAPoint(supervisorAppraisals.getStandardAPoint());
		newSupervisorAppraisalsDetails.setStandardB(supervisorAppraisals.getStandardB());
		newSupervisorAppraisalsDetails.setStandardBPoint(supervisorAppraisals.getStandardBPoint());
		newSupervisorAppraisalsDetails.setStandardC(supervisorAppraisals.getStandardC());
		newSupervisorAppraisalsDetails.setStandardCPoint(supervisorAppraisals.getStandardCPoint());
		newSupervisorAppraisalsDetails.setStandardD(supervisorAppraisals.getStandardD());
		newSupervisorAppraisalsDetails.setStandardDPoint(supervisorAppraisals.getStandardDPoint());
		newSupervisorAppraisalsDetails.setStandardE(supervisorAppraisals.getStandardE());
		newSupervisorAppraisalsDetails.setStandardEPoint(supervisorAppraisals.getStandardEPoint());
		newSupervisorAppraisalsDetails.setStandardF(supervisorAppraisals.getStandardF());
		newSupervisorAppraisalsDetails.setStandardFPoint(supervisorAppraisals.getStandardFPoint());
		newSupervisorAppraisalsDetails.setStandardG(supervisorAppraisals.getStandardG());
		newSupervisorAppraisalsDetails.setStandardGPoint(supervisorAppraisals.getStandardGPoint());
		newSupervisorAppraisalsDetails.setStandardH(supervisorAppraisals.getStandardH());
		newSupervisorAppraisalsDetails.setStandardHPoint(supervisorAppraisals.getStandardHPoint());
		newSupervisorAppraisalsDetails.setStandardI(supervisorAppraisals.getStandardI());
		newSupervisorAppraisalsDetails.setStandardIPoint(supervisorAppraisals.getStandardIPoint());
		newSupervisorAppraisalsDetails.setStandardJ(supervisorAppraisals.getStandardJ());
		newSupervisorAppraisalsDetails.setStandardJPoint(supervisorAppraisals.getStandardJPoint());
		newSupervisorAppraisalsDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
		newSupervisorAppraisalsDetails.setSupervisorTasksDetails(findSupervisorTasksDetails);
		newSupervisorAppraisalsDetails.setAppraisedEndDate(supervisorAppraisals.getAppraisedEndDate());
		newSupervisorAppraisalsDetails.setAppraisedStartDate(supervisorAppraisals.getAppraisedStartDate());
		newSupervisorAppraisalsDetails.setDescription(supervisorAppraisals.getDescription());
		
		
		SupervisorAppraisalsDetails responseSupervisorAppraisalsDetails = null;
			 try {
				 
				 responseSupervisorAppraisalsDetails = supervisorAppraisalsRepo.save(newSupervisorAppraisalsDetails);
				 SupervisorAppraisals domainSupervisorAppraisals = new SupervisorAppraisals();
				 domainSupervisorAppraisals.setStandardA(responseSupervisorAppraisalsDetails.getStandardA());
				 domainSupervisorAppraisals.setStandardAPoint(responseSupervisorAppraisalsDetails.getStandardAPoint());
				 domainSupervisorAppraisals.setStandardB(responseSupervisorAppraisalsDetails.getStandardB());
				 domainSupervisorAppraisals.setStandardBPoint(responseSupervisorAppraisalsDetails.getStandardBPoint());
				 domainSupervisorAppraisals.setStandardC(responseSupervisorAppraisalsDetails.getStandardC());
				 domainSupervisorAppraisals.setStandardCPoint(responseSupervisorAppraisalsDetails.getStandardCPoint());
				 domainSupervisorAppraisals.setStandardD(responseSupervisorAppraisalsDetails.getStandardD());
				 domainSupervisorAppraisals.setStandardDPoint(responseSupervisorAppraisalsDetails.getStandardDPoint());
				 domainSupervisorAppraisals.setStandardE(responseSupervisorAppraisalsDetails.getStandardE());
				 domainSupervisorAppraisals.setStandardEPoint(responseSupervisorAppraisalsDetails.getStandardEPoint());
				 domainSupervisorAppraisals.setStandardF(responseSupervisorAppraisalsDetails.getStandardF());
				 domainSupervisorAppraisals.setStandardFPoint(responseSupervisorAppraisalsDetails.getStandardFPoint());
				 domainSupervisorAppraisals.setStandardG(responseSupervisorAppraisalsDetails.getStandardG());
				 domainSupervisorAppraisals.setStandardGPoint(responseSupervisorAppraisalsDetails.getStandardGPoint());
				 domainSupervisorAppraisals.setStandardH(responseSupervisorAppraisalsDetails.getStandardH());
				 domainSupervisorAppraisals.setStandardHPoint(responseSupervisorAppraisalsDetails.getStandardHPoint());
				 domainSupervisorAppraisals.setStandardI(responseSupervisorAppraisalsDetails.getStandardI());
				 domainSupervisorAppraisals.setStandardIPoint(responseSupervisorAppraisalsDetails.getStandardIPoint());
				 domainSupervisorAppraisals.setStandardJ(responseSupervisorAppraisalsDetails.getStandardJ());
				 domainSupervisorAppraisals.setStandardJPoint(responseSupervisorAppraisalsDetails.getStandardJPoint());
				 domainSupervisorAppraisals.setAppraisedEndDate(responseSupervisorAppraisalsDetails.getAppraisedEndDate());
				 domainSupervisorAppraisals.setAppraisedStartDate(responseSupervisorAppraisalsDetails.getAppraisedStartDate());
				 domainSupervisorAppraisals.setProjectName(projectName);
				 domainSupervisorAppraisals.setSubordinateMember(memberName);
				 domainSupervisorAppraisals.setTaskName(taskName);
				 domainSupervisorAppraisals.setSupervisorName(supervisorName);
				 domainSupervisorAppraisals.setAppraisedEndDate(responseSupervisorAppraisalsDetails.getAppraisedEndDate());
				 domainSupervisorAppraisals.setAppraisedStartDate(responseSupervisorAppraisalsDetails.getAppraisedStartDate());
				 domainSupervisorAppraisals.setDescription(responseSupervisorAppraisalsDetails.getDescription());
				 
				  Application.getLogger().info("addSelfAppraisals method in SelfAppraisalsDetails DAO Implementation. At this point new supervisor appraisal has successful saved to the database. Return supervisor appraisal from repo is"+domainSupervisorAppraisals);
					 
				  genericObject = (Container<T>) new Container<SupervisorAppraisals>(domainSupervisorAppraisals,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addSelfAppraisals method in SelfAppraisalsDetails DAO Implementation. At this point there is an error that as prevented saving supervisor appraisal to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}
