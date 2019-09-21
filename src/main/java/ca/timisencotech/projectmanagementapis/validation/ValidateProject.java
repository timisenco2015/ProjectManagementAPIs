package ca.timisencotech.projectmanagementapis.validation;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ca.timisencotech.projectmanagementapis.domain.Project;


public class ValidateProject implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Project project = (Project) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(project.getProjectName()!=null && project.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(project.getProjectName().charAt(0)) && !Character.isDigit(project.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<project.getProjectName().length() && !invalid; i++) {
		                	  if (!Character.isAlphabetic(project.getProjectName().charAt(i)) && !Character.isDigit(project.getProjectName().charAt(i)) && !Character.isWhitespace( project.getProjectName().charAt(i)))
	                    		  
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

		 if(project.getCreatedDate()!=null )
		 {

			 Timestamp ts = project.getCreatedDate();
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
		 
		 
		 
		 if(project.getStartDate()!=null )
		 {

			 Timestamp ts = project.getStartDate();
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
		 
		 
		 
		 if(project.getEndDate()!=null )
		 {

			 Timestamp ts = project.getEndDate();
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
		 if(project.getCreatedBy()!=null&& project.getCreatedBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(project.getCreatedBy()).matches())
		       {
		    	   errors.rejectValue("createdby", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("createdby", "field required");
	     }
		 
		 
		 if(project.getDescription()!=null&& project.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(project.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		
	}
		
	
}
