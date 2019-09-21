package ca.timisencotech.projectmanagementapis.validation;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.Task;


public class ValidateTask implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return Task.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Task task = (Task) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(task.getProjectName()!=null && task.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(task.getProjectName().charAt(0)) && !Character.isDigit(task.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<task.getProjectName().length() && !invalid; i++) {
		                	 if (!Character.isAlphabetic(task.getProjectName().charAt(i)) && !Character.isDigit(task.getProjectName().charAt(i)) && !Character.isWhitespace(task.getProjectName().charAt(i)))
	                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("projectName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("projectName", "task name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("projectName", "field required");
		   }
		 
		 
		 if(task.getTaskName()!=null && task.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(task.getTaskName().charAt(0)) && !Character.isDigit(task.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<task.getTaskName().length() && !invalid; i++) {
 if (!Character.isAlphabetic(task.getTaskName().charAt(i)) && !Character.isDigit(task.getTaskName().charAt(i)) && !Character.isWhitespace(task.getTaskName().charAt(i)))
	                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("taskName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("taskName", "task name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("taskName", "field required");
		   }
		 
		 
		 

		 if(task.getCreatedDate()!=null )
		 {

			 Timestamp ts = task.getCreatedDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("createdDate", "task created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("createdDate", "field required");
		 }
		 
		 
		 
		 if(task.getStartDate()!=null )
		 {

			 Timestamp ts = task.getStartDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("startDate", "task created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("startDate", "field required");
		 }
		 
		 
		 
		 if(task.getEndDate()!=null )
		 {

			 Timestamp ts = task.getEndDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("endDate", "task created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("endDate", "field required");
		 }
		
		
		 
		// starting from line 23 to line 40 checks for valid email address 
		 if(task.getCreatedBy()!=null&& task.getCreatedBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(task.getCreatedBy()).matches())
		       {
		    	   errors.rejectValue("createdby", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("createdby", "field required");
	     }
		 
		 
		 if(task.getDescription()!=null&& task.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(task.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "task description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		
	}
		
	
}
