package ca.timisencotech.projectmanagementapis.validation;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.Companies;


public class ValidateCompanies implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return Companies.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Companies companies = (Companies) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		
		
		
		 if(companies.getAddress()!=null && companies.getAddress().length()>0 && !Character.isWhitespace(companies.getAddress().charAt(0)))
	     {
			 boolean invalid = false;
			 for(int i=0; i<companies.getAddress().length() && !invalid; i++) 
	         {

				 if (!Character.isDigit(companies.getAddress().charAt(i)) && !Character.isAlphabetic(companies.getAddress().charAt(i)) && !Character.isWhitespace(companies.getAddress().charAt(i)) && companies.getAddress().charAt(i)!='.' && companies.getAddress().charAt(i)!=','&& companies.getAddress().charAt(i)!='-')
	             {
					 invalid = true;
					 errors.rejectValue("address", "field contains invalid characters");
	                  
	             }
	           }
			 if(!invalid)
                {
                	if(companies.getAddress().length()<10 || companies.getAddress().length()>100)
                	{
                		 errors.rejectValue("address", "field length must be between 10 and 80");
   	                  
                	}
                }
	        }
		 else
		 { 
	    	errors.rejectValue("address", "field required");
	     }
		
		
		
		
		
		if(companies.getCompanyName()!=null && companies.getCompanyName().length()>0)
		 {
			
			 if (!Character.isWhitespace(companies.getCompanyName().charAt(0)) && !Character.isDigit(companies.getCompanyName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<companies.getCompanyName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(companies.getCompanyName().charAt(i)) && !Character.isDigit(companies.getCompanyName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("companyName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("companyName", "company name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("companyName", "field required");
		   }

		
	
		if(companies.getCity()!=null && companies.getCity().length()>0)
		 {
		      
			 if (!Character.isWhitespace(companies.getCity().charAt(0)) && !Character.isDigit(companies.getCity().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<companies.getCity().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(companies.getCity().charAt(i)) && !Character.isWhitespace(companies.getCity().charAt(i)) && companies.getCity().charAt(i)!='_' && companies.getCity().charAt(i)!='-')
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("city", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("city", "city must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("city", "field required");
		   }
		
		
		
		if(companies.getStateProvince()!=null && companies.getStateProvince().length()>0)
		 {
		      
			 if (!Character.isWhitespace(companies.getStateProvince().charAt(0)) && !Character.isDigit(companies.getStateProvince().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<companies.getStateProvince().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(companies.getStateProvince().charAt(i)) && !Character.isWhitespace(companies.getStateProvince().charAt(i)) && companies.getStateProvince().charAt(i)!='_' && companies.getStateProvince().charAt(i)!='-')
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("stateProvince", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("stateProvince", "stateProvince must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("stateProvince", "field required");
		   }
		
		
		
		if(companies.getCountry()!=null && companies.getCountry().length()>0)
		 {
		      
			 if (!Character.isWhitespace(companies.getCountry().charAt(0)) && !Character.isDigit(companies.getCountry().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<companies.getCountry().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(companies.getCountry().charAt(i)) && !Character.isWhitespace(companies.getCountry().charAt(i)) && companies.getCountry().charAt(i)!='_' && companies.getCountry().charAt(i)!='-')
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("country", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("country", "country must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("country", "field required");
		   }
		
		
		
		
		
		 if(companies.getPhoneNumber()!=null&& companies.getPhoneNumber().length()>0 && !Character.isWhitespace(companies.getPhoneNumber().charAt(0)))
	     {
			String phoneNoRegex = "(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
		
			 Pattern pat = Pattern.compile(phoneNoRegex);
		       if(!pat.matcher(companies.getPhoneNumber()).matches())
		       {
		    	   errors.rejectValue("phoneNo", "ePhone number is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("phoneNo", "field required");
	     } 
		 
		 
		 
		 
		 
		// starting from line 23 to line 40 checks for valid email address 
		 if(companies.getRegisterBy()!=null&& companies.getRegisterBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(companies.getRegisterBy()).matches())
		       {
		    	   errors.rejectValue("registerBy", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("registerBy", "field required");
	     }
		 
		 
		
		
	}
		
	
}
