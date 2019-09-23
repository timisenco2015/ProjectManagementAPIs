package ca.timisencotech.projectmanagementapis.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ca.timisencotech.projectmanagementapis.domain.User;

import java.util.regex.Pattern;


public class ValidateUser  implements Validator{

    boolean invalid = false;
	public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
		@Override
		public void validate(Object target, Errors errors) {
			User user = (User) target;
			
			
			 // starting from line 23 to line 40 checks for valid email address 
			 if(user.getUserEmail()!=null&& user.getUserEmail().length()>0 && !Character.isWhitespace(user.getUserEmail().charAt(0)))
		     {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			                "A-Z]{2,7}$";
				 
				 Pattern pat = Pattern.compile(emailRegex);
			       if(!pat.matcher(user.getUserEmail()).matches())
			       {
			    	   errors.rejectValue("email", "email address is invalid");
			       }
		     }
			 else
			 {
				 errors.rejectValue("email", "field required");
		     }
			 
			 
			// starting from line 42 to line 69 checks for valid firstName 
			 if(user.getFirstName()!=null&& user.getFirstName().length()>0 && !Character.isWhitespace(user.getFirstName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<user.getFirstName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(user.getFirstName().charAt(i)) && user.getFirstName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("firstName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(user.getFirstName().length()<2 || user.getFirstName().length()>30)
				                	{
				                		 errors.rejectValue("firstName", "field length must be between 10 and 30");
				   	                  
				                	}
				                }   
		       }
			   else
			   {
				   errors.rejectValue("firstName", "field required");
			   }

			             
			 // starting from line 71 to line 97 checks for valid middleName 
			 if(user.getMiddleName()!=null&& user.getMiddleName().length()>0 && !Character.isWhitespace(user.getMiddleName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<user.getMiddleName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(user.getMiddleName().charAt(i)) && user.getMiddleName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("middleName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(user.getMiddleName().length()<1 || user.getMiddleName().length()>30)
				                	{
				                		 errors.rejectValue("middleName", "field length must be between 10 and 30");
				   	                  
				                	}
				                }   
		       }
			  
			
			 
			 // starting from line 101 to line 127 checks for valid lastName 
			 if(user.getLastName()!=null&& user.getLastName().length()>0 && !Character.isWhitespace(user.getLastName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<user.getLastName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(user.getLastName().charAt(i)) && user.getLastName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("lastName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(user.getLastName().length()<2 || user.getLastName().length()>30)
				                	{
				                		 errors.rejectValue("lastName", "field length must be between 10 and 30");
				   	                  
				                	}
				                }   
		       }
			   else
			   {
				   errors.rejectValue("lastName", "field required");
			   }

			 
			
			
			
			
			 // starting from line 136 to line 160 checks for valid user address 
			
			 if(user.getUserAddress()!=null && user.getUserAddress().length()>0 && !Character.isWhitespace(user.getUserAddress().charAt(0)))
		     {
				 for(int i=0; i<user.getUserAddress().length() && !invalid; i++) 
		         {

					 if (!Character.isDigit(user.getUserAddress().charAt(i)) && !Character.isAlphabetic(user.getUserAddress().charAt(i)) && !Character.isWhitespace(user.getUserAddress().charAt(i)) && user.getUserAddress().charAt(i)!='.' && user.getUserAddress().charAt(i)!=','&& user.getUserAddress().charAt(i)!='-')
		             {
						 invalid = true;
						 errors.rejectValue("userAddress", "field contains invalid characters");
		                  
		             }
		           }
				 if(!invalid)
	                {
	                	if(user.getUserAddress().length()<10 || user.getUserAddress().length()>100)
	                	{
	                		 errors.rejectValue("userAddress", "field length must be between 10 and 80");
	   	                  
	                	}
	                }
		        }
			 else
			 { 
		    	errors.rejectValue("userAddress", "field required");
		     }
			 
			 // starting from line 162 to line 178 checks for valid user phone number 
				
			 if(user.getPhoneNo()!=null&& user.getPhoneNo().length()>0 && !Character.isWhitespace(user.getPhoneNo().charAt(0)))
		     {
				String phoneNoRegex = "(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
			
				 Pattern pat = Pattern.compile(phoneNoRegex);
			       if(!pat.matcher(user.getPhoneNo()).matches())
			       {
			    	   errors.rejectValue("phoneNo", "ePhone number is invalid");
			       }
		     }
			 else
			 {
				 errors.rejectValue("phoneNo", "field required");
		     } 
			 
			 
			 
			// starting from line 181 to line 197 checks for valid phone country code 
				
		/*	 if(userDetail.getCountryPhoneCode()!=null&& userDetail.getCountryPhoneCode().length()>0 && !Character.isWhitespace(userDetail.getCountryPhoneCode().charAt(0)))
		     {
				String countryPhoneCodeRegex = "/^(\\+?\\d{1,3}|\\d{1,4})$/";
			
				 Pattern pat = Pattern.compile(countryPhoneCodeRegex);
			       if(!pat.matcher(userDetail.getCountryPhoneCode()).matches())
			       {
			    	   errors.rejectValue("phoneCode", "Country phone code is invalid");
			       }
		     }
			 else
			 {
				 errors.rejectValue("phoneCode", "field required");
		     } 
			 
			*/
			 
			 
			 
			 
			 
		}
       

}
