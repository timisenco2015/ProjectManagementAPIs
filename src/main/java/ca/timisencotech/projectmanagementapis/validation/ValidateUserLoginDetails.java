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
			
			// String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})";
			 //Pattern pat = Pattern.compile(passwordRegex);
		     if(userLoginDetail.getPassword().length()< 8 && userLoginDetail.getPassword().length()>15)  
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
		    	 for(int i=0; i<userLoginDetail.getPassword().length();i++)
		    	 {
		    		 if(Character.isDigit(userLoginDetail.getPassword().charAt(i)))
		    				 {
		    			       digiCount+=1;
		    			       System.out.println("--**-> "+userLoginDetail.getPassword().charAt(i));
		    			       System.out.println("---> "+digiCount);
		    				 }
		    		
		    		 else if(Character.isLowerCase(userLoginDetail.getPassword().charAt(i)))
		    		 {
		    			 lowerCaseCount+=1;
		    		 }
		    		 else if(Character.isUpperCase(userLoginDetail.getPassword().charAt(i)))
		    		 {
		    			 upperCaseCount+=1;
		    		 }
		    		 else if(userLoginDetail.getPassword().charAt(i)=='?' || 
		    				 	userLoginDetail.getPassword().charAt(i)=='*' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='[' || 
		    				 	userLoginDetail.getPassword().charAt(i)=='!' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='@' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='#' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='$' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='%' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='^' ||
		    				 	userLoginDetail.getPassword().charAt(i)=='&' ||
		    				 	userLoginDetail.getPassword().charAt(i)==']')
		    		 {
		    			 specialCharCount+=1;
		    		 }
		    		 if (Character.isAlphabetic(userLoginDetail.getPassword().charAt(i)))
		    		 {
		    			 alphabetCount+=1;
		    		 }
		    		
			}
		    	 if(lowerCaseCount<=0 || upperCaseCount<=0 || specialCharCount<=0 ||digiCount<=0 || alphabetCount<=0 )
	    		 {
		    		 System.out.println(lowerCaseCount+" "+upperCaseCount+" "+specialCharCount+" "+digiCount+" "+alphabetCount);
			    	 
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
