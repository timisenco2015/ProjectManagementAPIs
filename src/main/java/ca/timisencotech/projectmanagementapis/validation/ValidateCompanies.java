package ca.timisencotech.projectmanagementapis.validation;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.Company;


public class ValidateCompanies implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return Company.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Company company = (Company) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		
		
		
		 if(company.getAddress()!=null && company.getAddress().length()>0 && !Character.isWhitespace(company.getAddress().charAt(0)))
	     {
			 boolean invalid = false;
			 for(int i=0; i<company.getAddress().length() && !invalid; i++) 
	         {

				 if (!Character.isDigit(company.getAddress().charAt(i)) && !Character.isAlphabetic(company.getAddress().charAt(i)) && !Character.isWhitespace(company.getAddress().charAt(i)) && company.getAddress().charAt(i)!='.' && company.getAddress().charAt(i)!=','&& company.getAddress().charAt(i)!='-')
	             {
					 invalid = true;
					 errors.rejectValue("address", "field contains invalid characters");
	                  
	             }
	           }
			 if(!invalid)
                {
                	if(company.getAddress().length()<10 || company.getAddress().length()>100)
                	{
                		 errors.rejectValue("address", "field length must be between 10 and 80");
   	                  
                	}
                }
	        }
		 else
		 { 
	    	errors.rejectValue("address", "field required");
	     }
		
		
		
		
		
		if(company.getCompanyName()!=null && company.getCompanyName().length()>0)
		 {
			
			 if (!Character.isWhitespace(company.getCompanyName().charAt(0)) && !Character.isDigit(company.getCompanyName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<company.getCompanyName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(company.getCompanyName().charAt(i)) && !Character.isDigit(company.getCompanyName().charAt(i)))
		                    		  
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

		
	
		if(company.getCity()!=null && company.getCity().length()>0)
		 {
		      
			 if (!Character.isWhitespace(company.getCity().charAt(0)) && !Character.isDigit(company.getCity().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<company.getCity().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(company.getCity().charAt(i)) && !Character.isWhitespace(company.getCity().charAt(i)) && company.getCity().charAt(i)!='_' && company.getCity().charAt(i)!='-')
		                    		  
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
		
		
		
		if(company.getStateProvince()!=null && company.getStateProvince().length()>0)
		 {
		      
			 if (!Character.isWhitespace(company.getStateProvince().charAt(0)) && !Character.isDigit(company.getStateProvince().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<company.getStateProvince().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(company.getStateProvince().charAt(i)) && !Character.isWhitespace(company.getStateProvince().charAt(i)) && company.getStateProvince().charAt(i)!='_' && company.getStateProvince().charAt(i)!='-')
		                    		  
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
		
		
		
		if(company.getCountry()!=null && company.getCountry().length()>0)
		 {
		      
			 if (!Character.isWhitespace(company.getCountry().charAt(0)) && !Character.isDigit(company.getCountry().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<company.getCountry().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(company.getCountry().charAt(i)) && !Character.isWhitespace(company.getCountry().charAt(i)) && company.getCountry().charAt(i)!='_' && company.getCountry().charAt(i)!='-')
		                    		  
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
		
		
		
		
		
		 if(company.getPhoneNumber()!=null&& company.getPhoneNumber().length()>0 && !Character.isWhitespace(company.getPhoneNumber().charAt(0)))
	     {
			String phoneNoRegex = "(\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{4})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";
		
			 Pattern pat = Pattern.compile(phoneNoRegex);
		       if(!pat.matcher(company.getPhoneNumber()).matches())
		       {
		    	   errors.rejectValue("phoneNo", "ePhone number is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("phoneNo", "field required");
	     } 
		 
		 
		 
		 
		 
		// starting from line 23 to line 40 checks for valid email address 
		 if(company.getRegisterBy()!=null&& company.getRegisterBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(company.getRegisterBy()).matches())
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
