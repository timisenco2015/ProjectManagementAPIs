package ca.timisencotech.projectmanagementapis.validation;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.UserSignUpDetail;

public class ValidateUserSignUpDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return UserSignUpDetail.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserSignUpDetail userSignUpDetail = (UserSignUpDetail) target;
		 // starting from line 23 to line 40 checks for valid email address 
		 if(userSignUpDetail.getUserEmail()!=null&& userSignUpDetail.getUserEmail().length()>0 && !Character.isWhitespace(userSignUpDetail.getUserEmail().charAt(0)))
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(userSignUpDetail.getUserEmail()).matches())
		       {
		    	   errors.rejectValue("userEmail", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("userEmail", "field required");
	     }
		 
		 
		 if(userSignUpDetail.getPassword()!=null&& userSignUpDetail.getPassword().length()>0 && !Character.isWhitespace(userSignUpDetail.getPassword().charAt(0)))
	     {
			
			// String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})";
			 //Pattern pat = Pattern.compile(passwordRegex);
		     if(userSignUpDetail.getPassword().length()< 8 && userSignUpDetail.getPassword().length()>15)  
		     {
		    	 errors.rejectValue("password", "Minimum password length must be 8 and maximum must be 15");
		     }
		     
		     else
		     {
		    	 int lowerCaseCount=0;
		    	 int upperCaseCount=0;
		    	 int specialCharCount=0;
		    	 int digiCount=0;
		    	 int alphabetCount=0;
		    	 for(int i=0; i<userSignUpDetail.getPassword().length();i++)
		    	 {
		    		 if(Character.isDigit(userSignUpDetail.getPassword().charAt(i)))
		    				 {
		    			       digiCount+=1;
		    			   }
		    		
		    		 else if(Character.isLowerCase(userSignUpDetail.getPassword().charAt(i)))
		    		 {
		    			 lowerCaseCount+=1;
		    		 }
		    		 else if(Character.isUpperCase(userSignUpDetail.getPassword().charAt(i)))
		    		 {
		    			 upperCaseCount+=1;
		    		 }
		    		 else if(userSignUpDetail.getPassword().charAt(i)=='?' || 
		    				 	userSignUpDetail.getPassword().charAt(i)=='*' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='[' || 
		    				 	userSignUpDetail.getPassword().charAt(i)=='!' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='@' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='#' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='$' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='%' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='^' ||
		    				 	userSignUpDetail.getPassword().charAt(i)=='&' ||
		    				 	userSignUpDetail.getPassword().charAt(i)==']')
		    		 {
		    			 specialCharCount+=1;
		    		 }
		    		 if (Character.isAlphabetic(userSignUpDetail.getPassword().charAt(i)))
		    		 {
		    			 alphabetCount+=1;
		    		 }
		    		
			}
		    	 if(lowerCaseCount<=0 || upperCaseCount<=0 || specialCharCount<=0 ||digiCount<=0 || alphabetCount<=0 )
	    		 {
		    		
	    			 errors.rejectValue("password", "Minimum password length must be 8 and maximum must be 15 \n"
	    	   		+ "Password must have at least one uppercase and one lowercase \n"
	    	   		+ "Password must have at least one special character e.g. @, &, #, !, e.t.c \n"
	    	   		+ "Password must have at least one number or digits");
	       }
		     }
	     }
		 else
		 {
			 errors.rejectValue("password", "field required");
	     }
		
	}
	
	
}
