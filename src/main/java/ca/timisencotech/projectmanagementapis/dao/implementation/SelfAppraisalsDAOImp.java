package ca.timisencotech.projectmanagementapis.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.SelfAppraisalsDAO;
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.dto.SelfAppraisalsDetails;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;
import ca.timisencotech.projectmanagementapis.exception.PersistentException;
import ca.timisencotech.projectmanagementapis.repository.SelfAppraisalsRepo;
import ca.timisencotech.projectmanagementapis.repository.TaskAssignedMemberRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Repository
public class SelfAppraisalsDAOImp implements SelfAppraisalsDAO {
	
	@Autowired
	SelfAppraisalsRepo selfAppraisalsDetailsRepo;
	
	@Autowired
	TaskAssignedMemberRepo taskAssignedMemberDetailsRepo;
	
	
	PersistentException persistentException = new PersistentException();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Container<T> addSelfAppraisals(SelfAppraisals selfAppraisals) {
		Container<T> genericObject=null; 
		
		
		String projectName = selfAppraisals.getProjectName();
		String memberName = selfAppraisals.getSubordinateMember();
		String taskName = selfAppraisals.getTaskName();
		
		TaskAssignedMembersDetails findTaskAssignedMembersDetails = taskAssignedMemberDetailsRepo.findTaskAssignedMember(projectName,memberName,taskName); 
		if(findTaskAssignedMembersDetails==null)
		{
			genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleSearchReturnNull("We dont have either  or project name: "+projectName+" member name:"+memberName+"task name:"+taskName+" in our database"),"Error Object");
			Application.getLogger().info("addSelfAppraisals method in SelfAppraisals DAO Implementation. It seems that you have not been assigned to this task yet");
			
		}
		else
		{
		
		SelfAppraisalsDetails newSelfAppraisalsDetails = new SelfAppraisalsDetails();
		newSelfAppraisalsDetails.setStandardA(selfAppraisals.getStandardA());
		newSelfAppraisalsDetails.setStandardAPoint(selfAppraisals.getStandardAPoint());
		newSelfAppraisalsDetails.setStandardB(selfAppraisals.getStandardB());
		newSelfAppraisalsDetails.setStandardBPoint(selfAppraisals.getStandardBPoint());
		newSelfAppraisalsDetails.setStandardC(selfAppraisals.getStandardC());
		newSelfAppraisalsDetails.setStandardCPoint(selfAppraisals.getStandardCPoint());
		newSelfAppraisalsDetails.setStandardD(selfAppraisals.getStandardD());
		newSelfAppraisalsDetails.setStandardDPoint(selfAppraisals.getStandardDPoint());
		newSelfAppraisalsDetails.setStandardE(selfAppraisals.getStandardE());
		newSelfAppraisalsDetails.setStandardEPoint(selfAppraisals.getStandardEPoint());
		newSelfAppraisalsDetails.setStandardF(selfAppraisals.getStandardF());
		newSelfAppraisalsDetails.setStandardFPoint(selfAppraisals.getStandardFPoint());
		newSelfAppraisalsDetails.setStandardG(selfAppraisals.getStandardG());
		newSelfAppraisalsDetails.setStandardGPoint(selfAppraisals.getStandardGPoint());
		newSelfAppraisalsDetails.setStandardH(selfAppraisals.getStandardH());
		newSelfAppraisalsDetails.setStandardHPoint(selfAppraisals.getStandardHPoint());
		newSelfAppraisalsDetails.setStandardI(selfAppraisals.getStandardI());
		newSelfAppraisalsDetails.setStandardIPoint(selfAppraisals.getStandardIPoint());
		newSelfAppraisalsDetails.setStandardJ(selfAppraisals.getStandardJ());
		newSelfAppraisalsDetails.setStandardJPoint(selfAppraisals.getStandardJPoint());
		newSelfAppraisalsDetails.setTaskAssignedMembersDetails(findTaskAssignedMembersDetails);
		newSelfAppraisalsDetails.setAppraisedEndDate(selfAppraisals.getAppraisedEndDate());
		newSelfAppraisalsDetails.setAppraisedStartDate(selfAppraisals.getAppraisedStartDate());
		newSelfAppraisalsDetails.setDescription(selfAppraisals.getDescription());
		SelfAppraisalsDetails responseSelfAppraisalsDetails = null;
			 try {
				 
				 responseSelfAppraisalsDetails = selfAppraisalsDetailsRepo.save(newSelfAppraisalsDetails);
				 SelfAppraisals domainSelfAppraisals = new SelfAppraisals();
				 domainSelfAppraisals.setStandardA(responseSelfAppraisalsDetails.getStandardA());
				 domainSelfAppraisals.setStandardAPoint(responseSelfAppraisalsDetails.getStandardAPoint());
				 domainSelfAppraisals.setStandardB(responseSelfAppraisalsDetails.getStandardB());
				 domainSelfAppraisals.setStandardBPoint(responseSelfAppraisalsDetails.getStandardBPoint());
				 domainSelfAppraisals.setStandardC(responseSelfAppraisalsDetails.getStandardC());
				 domainSelfAppraisals.setStandardCPoint(responseSelfAppraisalsDetails.getStandardCPoint());
				 domainSelfAppraisals.setStandardD(responseSelfAppraisalsDetails.getStandardD());
				 domainSelfAppraisals.setStandardDPoint(responseSelfAppraisalsDetails.getStandardDPoint());
				 domainSelfAppraisals.setStandardE(responseSelfAppraisalsDetails.getStandardE());
				 domainSelfAppraisals.setStandardEPoint(responseSelfAppraisalsDetails.getStandardEPoint());
				 domainSelfAppraisals.setStandardF(responseSelfAppraisalsDetails.getStandardF());
				 domainSelfAppraisals.setStandardFPoint(responseSelfAppraisalsDetails.getStandardFPoint());
				 domainSelfAppraisals.setStandardG(responseSelfAppraisalsDetails.getStandardG());
				 domainSelfAppraisals.setStandardGPoint(responseSelfAppraisalsDetails.getStandardGPoint());
				 domainSelfAppraisals.setStandardH(responseSelfAppraisalsDetails.getStandardH());
				 domainSelfAppraisals.setStandardHPoint(responseSelfAppraisalsDetails.getStandardHPoint());
				 domainSelfAppraisals.setStandardI(responseSelfAppraisalsDetails.getStandardI());
				 domainSelfAppraisals.setStandardIPoint(responseSelfAppraisalsDetails.getStandardIPoint());
				 domainSelfAppraisals.setStandardJ(responseSelfAppraisalsDetails.getStandardJ());
				 domainSelfAppraisals.setStandardJPoint(responseSelfAppraisalsDetails.getStandardJPoint());
				 domainSelfAppraisals.setAppraisedEndDate(responseSelfAppraisalsDetails.getAppraisedEndDate());
				 domainSelfAppraisals.setAppraisedStartDate(responseSelfAppraisalsDetails.getAppraisedStartDate());
				 domainSelfAppraisals.setDescription(responseSelfAppraisalsDetails.getDescription());
				 domainSelfAppraisals.setProjectName(projectName);
				 domainSelfAppraisals.setSubordinateMember(memberName);
				 domainSelfAppraisals.setTaskName(taskName);
				
					 
				  genericObject = (Container<T>) new Container<SelfAppraisals>(domainSelfAppraisals,"Class Object");
			    } 
			 
		
			 
			 catch (DataAccessException dataAccessException) {
			    	
				 Application.getLogger().info("addSelfAppraisals method in SelfAppraisals DAO Implementation. At this point there is an error that as prevented saving your self appraisal to the database");
				 
				 genericObject = (Container<T>) new  Container<ApiError> (persistentException.handleDataAccessException((DataAccessException)dataAccessException),"Error Object");
		
			 
			 }
		}
		return genericObject;
	}


}
