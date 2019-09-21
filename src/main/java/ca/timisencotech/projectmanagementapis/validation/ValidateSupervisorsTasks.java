package ca.timisencotech.projectmanagementapis.validation;



import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;


public class ValidateSupervisorsTasks implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return SupervisorTasks.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupervisorTasks supervisorTasks = (SupervisorTasks) target;
		 // starting from line 23 to line 40 checks for valid email address 

		
		
		
		
		
		 if(supervisorTasks.getProjectName()!=null && supervisorTasks.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorTasks.getProjectName().charAt(0)) && !Character.isDigit(supervisorTasks.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<supervisorTasks.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorTasks.getProjectName().charAt(i)) && !Character.isDigit(supervisorTasks.getProjectName().charAt(i)) && !Character.isWhitespace(supervisorTasks.getProjectName().charAt(i)))
		                    		  
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
		
		
		if(supervisorTasks.getTaskName()!=null && supervisorTasks.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorTasks.getTaskName().charAt(0)) && !Character.isDigit(supervisorTasks.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<supervisorTasks.getTaskName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorTasks.getTaskName().charAt(i)) && !Character.isDigit(supervisorTasks.getTaskName().charAt(i))&& !Character.isWhitespace(supervisorTasks.getTaskName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("taskName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("taskName", "project name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("taskName", "field required");
		   }
		 
	
		
		if(supervisorTasks.getSupervisorName()!=null&& supervisorTasks.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorTasks.getSupervisorName()).matches())
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
