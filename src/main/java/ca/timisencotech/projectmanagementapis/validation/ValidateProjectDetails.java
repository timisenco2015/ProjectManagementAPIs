package ca.timisencotech.projectmanagementapis.validation;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;


public class ValidateProjectDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectInformation.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectInformation projectInformation = (ProjectInformation) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectInformation.getProjectName()!=null && projectInformation.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectInformation.getProjectName().charAt(0)) && !Character.isDigit(projectInformation.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectInformation.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectInformation.getProjectName().charAt(i)) && !Character.isDigit(projectInformation.getProjectName().charAt(i)))
		                    		  
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

		 if(projectInformation.getCreatedDate()!=null )
		 {

			 Timestamp ts = projectInformation.getCreatedDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("createdDate", "project created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("createdDate", "field required");
		 }
		 
		 
		 
		 if(projectInformation.getStartDate()!=null )
		 {

			 Timestamp ts = projectInformation.getStartDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("startDate", "project created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("startDate", "field required");
		 }
		 
		 
		 
		 if(projectInformation.getEndDate()!=null )
		 {

			 Timestamp ts = projectInformation.getEndDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("endDate", "project created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("endDate", "field required");
		 }
		
		
		 
		// starting from line 23 to line 40 checks for valid email address 
		 if(projectInformation.getCreatedBy()!=null&& projectInformation.getCreatedBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectInformation.getCreatedBy()).matches())
		       {
		    	   errors.rejectValue("createdby", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("createdby", "field required");
	     }
		 
		 
		 if(projectInformation.getDescription()!=null&& projectInformation.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(projectInformation.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		
	}
		
	
}
