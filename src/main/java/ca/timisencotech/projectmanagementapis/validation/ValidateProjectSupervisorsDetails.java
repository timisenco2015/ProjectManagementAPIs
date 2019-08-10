package ca.timisencotech.projectmanagementapis.validation;



import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;


public class ValidateProjectSupervisorsDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectSupervisorsDetail.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectSupervisorsDetail projectSupervisorsDetail = (ProjectSupervisorsDetail) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectSupervisorsDetail.getProjectName()!=null && projectSupervisorsDetail.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectSupervisorsDetail.getProjectName().charAt(0)) && !Character.isDigit(projectSupervisorsDetail.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectSupervisorsDetail.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectSupervisorsDetail.getProjectName().charAt(i)) && !Character.isDigit(projectSupervisorsDetail.getProjectName().charAt(i))&& !Character.isWhitespace(projectSupervisorsDetail.getProjectName().charAt(i)))
		                    		  
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

		 if(projectSupervisorsDetail.getSupervisorName()!=null&& projectSupervisorsDetail.getSupervisorName().length()>0 && !Character.isWhitespace(projectSupervisorsDetail.getSupervisorName().charAt(0)))
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectSupervisorsDetail.getSupervisorName()).matches())
		       {
		    	   errors.rejectValue("supervisorName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("supervisorName", "field required");
	     }
		 	
	
}
}
