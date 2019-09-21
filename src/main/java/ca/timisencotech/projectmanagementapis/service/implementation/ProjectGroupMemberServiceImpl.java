package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupMemberDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.ProjectGroupMemberService;
import ca.timisencotech.projectmanagementapis.validation.Container;
import ca.timisencotech.projectmanagementapis.validation.ValidateProjectGroupMember;


@Service("ProjectGroupMemberDetailsService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ProjectGroupMemberServiceImpl<T> implements ProjectGroupMemberService{
	
	
	@Autowired
	private ProjectGroupMemberDAOImp projectGroupMemberDAOImp;
	
	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> addMemberToProjectGroup(ProjectGroupMembers projectGroupMembers,BindingResult result) {
		
  
		Container<T> genericObject=null;
		new ValidateProjectGroupMember().validate(projectGroupMembers, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("project group member validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("addProjectGroupMemberDetails method in ProjectGroupMemberDetails Service Implementation. Member  has already been added to project group in the database");
			    
				genericObject = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
					
			}
		return genericObject;
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> changeProjectMemberGroup(ProjectGroupMembers projectGroupMembers,BindingResult result)
	{
		Container<T> genericObject=null;
		new ValidateProjectGroupMember().validate(projectGroupMembers, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("project group member validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("changeProjectMemberGroup method in ProjectGroupMemberDetails Service Implementation. Member project group has already been changed in the database");
			    
				genericObject = projectGroupMemberDAOImp.changeProjectMemberGroup(projectGroupMembers);
					
			}
		return genericObject;
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> Container<T> removeMemberFromProjectGroup(ProjectGroupMembers projectGroupMembers,BindingResult result)
	{
		Container<T> genericObject=null;
		new ValidateProjectGroupMember().validate(projectGroupMembers, result);
		ValidationError  validationError = new ValidationError()	;
			
			if (result.hasErrors())
			{
				
				validationError.setErrorStatus("Failed");
				validationError.setMessage("Failed validation test for all or most of the fields");
				validationError.setAllErrorObject(result.getAllErrors());
	   
			 genericObject = (Container<T>) new  Container<ValidationError> (validationError,"Error Object");
			 Application.getLogger().info("project group member validation error. Error info: "+validationError.getMessageObject());

			}
			
			else
			{
				Application.getLogger().info("removeMemberFromProjectGroup method in ProjectGroupMemberDetails Service Implementation. Member  has already been removed from project group in the database");
			    
				genericObject = projectGroupMemberDAOImp.removeMemberFromProjectGroup(projectGroupMembers);
					
			}
		return genericObject;
	}



}
