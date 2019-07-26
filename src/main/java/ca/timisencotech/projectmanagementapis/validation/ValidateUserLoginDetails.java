package ca.timisencotech.projectmanagementapis.validation;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;

public class ValidateUserLoginDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return UserLoginDetail.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserLoginDetail userLoginDetail = (UserLoginDetail) target;
		 // starting from line 23 to line 40 checks for valid email address 
		 if(userLoginDetail.getUserEmail()!=null&& userLoginDetail.getUserEmail().length()>0 && !Character.isWhitespace(userLoginDetail.getUserEmail().charAt(0)))
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(userLoginDetail.getUserEmail()).matches())
		       {
		    	   errors.rejectValue("userEmail", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("userEmail", "field required");
	     }
		 
		 
		 if(userLoginDetail.getPassword()!=null&& userLoginDetail.getPassword().length()>0 && !Character.isWhitespace(userLoginDetail.getPassword().charAt(0)))
	     {
			
			 String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})";
			 Pattern pat = Pattern.compile(passwordRegex);
		       if(!pat.matcher(userLoginDetail.getUserEmail()).matches())
		       {
		    	   errors.rejectValue("password", "Minimum password length must be 8 and maximum must be 15 \n"
		    	   		+ "Password must have at least one uppercase and one lowercase \n"
		    	   		+ "Password must have at least one special character e.g. @, &, #, !, e.t.c \n"
		    	   		+ "Password must have at least one number or digit");
		       }
			}
		 else
		 {
			 errors.rejectValue("userEmail", "field required");
	     }
		
	}
	
	
}
