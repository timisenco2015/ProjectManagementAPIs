package ca.timisencotech.projectmanagementapis.validation;



import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;



public class ValidateSupervisorsMembers implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return SupervisorsMembers.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupervisorsMembers supervisorsMembers = (SupervisorsMembers) target;
		 // starting from line 23 to line 40 checks for valid email address 

	
		// starting from line 42 to line 69 checks for valid firstName 
		 if(supervisorsMembers.getProjectName()!=null && supervisorsMembers.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorsMembers.getProjectName().charAt(0)) && !Character.isDigit(supervisorsMembers.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<supervisorsMembers.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorsMembers.getProjectName().charAt(i)) && !Character.isDigit(supervisorsMembers.getProjectName().charAt(i)) && !Character.isWhitespace(supervisorsMembers.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 
		 
		 if(supervisorsMembers.getMemberName()!=null&& supervisorsMembers.getMemberName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorsMembers.getMemberName()).matches())
		       {
		    	   errors.rejectValue("memberName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("memberName", "field required");
	     }
		 
		 
		 
		 if(supervisorsMembers.getSupervisorName()!=null&& supervisorsMembers.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorsMembers.getSupervisorName()).matches())
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
