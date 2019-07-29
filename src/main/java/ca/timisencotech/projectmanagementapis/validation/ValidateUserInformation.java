package ca.timisencotech.projectmanagementapis.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ca.timisencotech.projectmanagementapis.domain.UserDetail;

import java.util.regex.Pattern;


public class ValidateUserInformation  implements Validator{

    boolean invalid = false;
	public boolean supports(Class<?> clazz) {
        return UserDetail.class.equals(clazz);
    }
	
		@Override
		public void validate(Object target, Errors errors) {
			UserDetail userDetail = (UserDetail) target;
			
			
			 // starting from line 23 to line 40 checks for valid email address 
			 if(userDetail.getUserEmail()!=null&& userDetail.getUserEmail().length()>0 && !Character.isWhitespace(userDetail.getUserEmail().charAt(0)))
		     {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			                "A-Z]{2,7}$";
				 
				 Pattern pat = Pattern.compile(emailRegex);
			       if(!pat.matcher(userDetail.getUserEmail()).matches())
			       {
			    	   errors.rejectValue("userEmail", "email address is invalid");
			       }
		     }
			 else
			 {
				 errors.rejectValue("userEmail", "field required");
		     }
			 
			 
			// starting from line 42 to line 69 checks for valid firstName 
			 if(userDetail.getFirstName()!=null&& userDetail.getFirstName().length()>0 && !Character.isWhitespace(userDetail.getFirstName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<userDetail.getFirstName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(userDetail.getFirstName().charAt(i)) && userDetail.getFirstName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("firstName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(userDetail.getFirstName().length()<2 || userDetail.getFirstName().length()>30)
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
			 if(userDetail.getMiddleName()!=null&& userDetail.getMiddleName().length()>0 && !Character.isWhitespace(userDetail.getMiddleName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<userDetail.getMiddleName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(userDetail.getMiddleName().charAt(i)) && userDetail.getMiddleName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("middleName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(userDetail.getMiddleName().length()<1 || userDetail.getMiddleName().length()>30)
				                	{
				                		 errors.rejectValue("middleName", "field length must be between 10 and 30");
				   	                  
				                	}
				                }   
		       }
			  
			
			 
			 // starting from line 101 to line 127 checks for valid lastName 
			 if(userDetail.getLastName()!=null&& userDetail.getLastName().length()>0 && !Character.isWhitespace(userDetail.getLastName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<userDetail.getLastName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(userDetail.getLastName().charAt(i)) && userDetail.getLastName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("lastName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(userDetail.getLastName().length()<2 || userDetail.getLastName().length()>30)
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
			
			 if(userDetail.getUserAddress()!=null && userDetail.getUserAddress().length()>0 && !Character.isWhitespace(userDetail.getUserAddress().charAt(0)))
		     {
				 for(int i=0; i<userDetail.getUserAddress().length() && !invalid; i++) 
		         {

					 if (!Character.isDigit(userDetail.getUserAddress().charAt(i)) && !Character.isAlphabetic(userDetail.getUserAddress().charAt(i)) && !Character.isWhitespace(userDetail.getUserAddress().charAt(i)) && userDetail.getUserAddress().charAt(i)!='.' && userDetail.getUserAddress().charAt(i)!=','&& userDetail.getUserAddress().charAt(i)!='-')
		             {
						 invalid = true;
						 errors.rejectValue("userAddress", "field contains invalid characters");
		                  
		             }
		           }
				 if(!invalid)
	                {
	                	if(userDetail.getUserAddress().length()<10 || userDetail.getUserAddress().length()>100)
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
				
			 if(userDetail.getPhoneNo()!=null&& userDetail.getPhoneNo().length()>0 && !Character.isWhitespace(userDetail.getPhoneNo().charAt(0)))
		     {
				String phoneNoRegex = "(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
			
				 Pattern pat = Pattern.compile(phoneNoRegex);
			       if(!pat.matcher(userDetail.getPhoneNo()).matches())
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
