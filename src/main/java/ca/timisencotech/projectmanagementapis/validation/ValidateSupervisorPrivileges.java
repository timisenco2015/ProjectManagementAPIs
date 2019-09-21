package ca.timisencotech.projectmanagementapis.validation;



import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;


public class ValidateSupervisorPrivileges implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return SupervisorsPrivileges.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupervisorsPrivileges supervisorsPrivileges = (SupervisorsPrivileges) target;
		 // starting from line 23 to line 40 checks for valid email address 
			
	
		
		// starting from line 42 to line 69 checks for valid firstName 
		 if(supervisorsPrivileges.getProjectName()!=null && supervisorsPrivileges.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorsPrivileges.getProjectName().charAt(0)) && !Character.isDigit(supervisorsPrivileges.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
			 	 
			 		
			 		
		                  for(int i=0; i<supervisorsPrivileges.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorsPrivileges.getProjectName().charAt(i)) && !Character.isDigit(supervisorsPrivileges.getProjectName().charAt(i))&& !Character.isWhitespace(supervisorsPrivileges.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 
		
		 
		 
		 
		 

		
		 
		
		 if(supervisorsPrivileges.getSupervisorName()!=null&& supervisorsPrivileges.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorsPrivileges.getSupervisorName()).matches())
		       {
		    	   errors.rejectValue("supervisorName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("supervisorName", "field required");
	     }
		 
		 
		 
		 if(supervisorsPrivileges.getPrivileges()!=null)
	     {
			 if( validatePrivileges(supervisorsPrivileges)==0)
			 {
				 errors.rejectValue("privileges", "list contains invalid privilege(s)");
			 }
	     }
		 
}
	
	
	public int validatePrivileges(SupervisorsPrivileges supervisorsPrivileges) {
	    int code =0;
		switch (supervisorsPrivileges.getPrivileges()) {
	        case canAssigntTask: 
	        	code= 1;
	        	break;
	        case canCreateTask: 
	        	code = 2;
	        	break;
	        case canRateMembers: 
	        	code = 3;
	        default:
	        	code =0;
	    }
	    return code;
	}
}
