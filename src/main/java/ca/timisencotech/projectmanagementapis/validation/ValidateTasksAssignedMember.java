package ca.timisencotech.projectmanagementapis.validation;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;


public class ValidateTasksAssignedMember implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return TaskAssignedMembers.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TaskAssignedMembers taskAssignedMembers = (TaskAssignedMembers) target;
		 // starting from line 23 to line 40 checks for valid email address 

		
		
		
		
	
		
		 if(taskAssignedMembers.getProjectName()!=null && taskAssignedMembers.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(taskAssignedMembers.getProjectName().charAt(0)) && !Character.isDigit(taskAssignedMembers.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<taskAssignedMembers.getProjectName().length() && !invalid; i++) {
		                	  if (!Character.isAlphabetic(taskAssignedMembers.getProjectName().charAt(i)) && !Character.isDigit(taskAssignedMembers.getProjectName().charAt(i)) && !Character.isWhitespace(taskAssignedMembers.getProjectName().charAt(i)))
	                    		  
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
		
		
		if(taskAssignedMembers.getTaskName()!=null && taskAssignedMembers.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(taskAssignedMembers.getTaskName().charAt(0)) && !Character.isDigit(taskAssignedMembers.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<taskAssignedMembers.getTaskName().length() && !invalid; i++) {
		                	  if (!Character.isAlphabetic(taskAssignedMembers.getTaskName().charAt(i)) && !Character.isDigit(taskAssignedMembers.getTaskName().charAt(i)) && !Character.isWhitespace(taskAssignedMembers.getTaskName().charAt(i)))
	                    		  
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
		 
	
		
		if(taskAssignedMembers.getAssignedBy()!=null&& taskAssignedMembers.getAssignedBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(taskAssignedMembers.getAssignedBy()).matches())
		       {
		    	   errors.rejectValue("assignedBy", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("assignedBy", "field required");
	     }

		if(taskAssignedMembers.getAssignedTo()!=null&& taskAssignedMembers.getAssignedTo().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(taskAssignedMembers.getAssignedTo()).matches())
		       {
		    	   errors.rejectValue("assignedTo", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("assignedTo", "field required");
	     }
		
		
		 if(taskAssignedMembers.getDescription()!=null&& taskAssignedMembers.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(taskAssignedMembers.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		 
		 
		 if(taskAssignedMembers.getDateAssigned()!=null )
		 {

			 Timestamp ts = taskAssignedMembers.getDateAssigned();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("dateAssigned", "task assigned date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("dateAssigned", "field required");
		 }
		
	}
}
