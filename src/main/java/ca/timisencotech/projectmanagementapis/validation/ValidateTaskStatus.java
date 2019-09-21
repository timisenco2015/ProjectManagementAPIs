package ca.timisencotech.projectmanagementapis.validation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;


public class ValidateTaskStatus implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return TaskStatus.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TaskStatus taskStatus = (TaskStatus) target;
		 // starting from line 23 to line 40 checks for valid email address 

		
	
		
		 if(taskStatus.getProjectName()!=null && taskStatus.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(taskStatus.getProjectName().charAt(0)) && !Character.isDigit(taskStatus.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<taskStatus.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(taskStatus.getProjectName().charAt(i)) && !Character.isDigit(taskStatus.getProjectName().charAt(i))&& !Character.isWhitespace(taskStatus.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		
		
		 if(taskStatus.getTaskName()!=null && taskStatus.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(taskStatus.getTaskName().charAt(0)) && !Character.isDigit(taskStatus.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<taskStatus.getTaskName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(taskStatus.getTaskName().charAt(i)) && !Character.isDigit(taskStatus.getTaskName().charAt(i))&& !Character.isWhitespace(taskStatus.getTaskName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("taskName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("taskName", "project name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("taskName", "field required");
		   }
		 
		
		 
		 if(taskStatus.getCompletedDate()!=null )
		 {

			 Timestamp ts = taskStatus.getCompletedDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("completedDate", "project completed date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("completedDate", "field required");
		 }
		 
		 
		 
		 
		 if(taskStatus.getUpdatedDate()!=null )
		 {

			 Timestamp ts = taskStatus.getUpdatedDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("updatedDate", "project status created date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("updatedDate", "field required");
		 }
		 
		 
		 if(taskStatus.getMemberName()!=null&& taskStatus.getMemberName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(taskStatus.getMemberName()).matches())
		       {
		    	   errors.rejectValue("memberName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("memberName", "field required");
	     }
		 
		 
		 
		 if(taskStatus.getDescription()!=null&& taskStatus.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(taskStatus.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		 
		 
		 if(!DoubleValidator.getInstance().isValid(""+taskStatus.getDonePercentage()))
		 {
			 errors.rejectValue("donePercentage", "project done percentage must be in double format e.g. 100.00");
		 }
		 
	
	
}
}
