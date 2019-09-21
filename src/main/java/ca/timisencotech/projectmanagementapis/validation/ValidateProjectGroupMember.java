package ca.timisencotech.projectmanagementapis.validation;



import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;



public class ValidateProjectGroupMember implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectGroupMembers.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectGroupMembers projectGroupMembers = (ProjectGroupMembers) target;
		 // starting from line 23 to line 40 checks for valid email address 

	
		
		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectGroupMembers.getProjectName()!=null && projectGroupMembers.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectGroupMembers.getProjectName().charAt(0)) && !Character.isDigit(projectGroupMembers.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectGroupMembers.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectGroupMembers.getProjectName().charAt(i)) && !Character.isDigit(projectGroupMembers.getProjectName().charAt(i)) && !Character.isWhitespace(projectGroupMembers.getProjectName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("projectName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("projectName", "project name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("projectName", "field required");
		   }
		 
		 
		 
		 
		 
		 if(projectGroupMembers.getMemberName()!=null&& projectGroupMembers.getMemberName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectGroupMembers.getMemberName()).matches())
		       {
		    	   errors.rejectValue("memberName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("memberName", "field required");
	     }
		 
		 
		 
	
		 
		 if(projectGroupMembers.getGroupName()!=null &&  projectGroupMembers.getGroupName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectGroupMembers.getGroupName().charAt(0)) && !Character.isDigit(projectGroupMembers.getGroupName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectGroupMembers.getGroupName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectGroupMembers.getGroupName().charAt(i)) && !Character.isDigit(projectGroupMembers.getGroupName().charAt(i))&&!Character.isWhitespace(projectGroupMembers.getGroupName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("groupName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("groupName", "project name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("groupName", "field required");
		   }
		 
	
		 if (projectGroupMembers.getIsActive() != true  &&  projectGroupMembers.getIsActive() != false )
		 {
			 errors.rejectValue("isActive", "field required");
		 }
		 
		 
		
		 
		 
		 
		 
		 if(projectGroupMembers.getActivitiesUpdate()!=null&& projectGroupMembers.getActivitiesUpdate().length()>0)
		 {
			 if (!Character.isWhitespace(projectGroupMembers.getActivitiesUpdate().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("activitiesUpdate", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
	}
}
