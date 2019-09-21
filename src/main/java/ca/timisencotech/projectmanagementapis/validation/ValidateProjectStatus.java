package ca.timisencotech.projectmanagementapis.validation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;


public class ValidateProjectStatus implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectStatus.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectStatus projectStatus = (ProjectStatus) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectStatus.getProjectName()!=null && projectStatus.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectStatus.getProjectName().charAt(0)) && !Character.isDigit(projectStatus.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectStatus.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectStatus.getProjectName().charAt(i)) && !Character.isDigit(projectStatus.getProjectName().charAt(i))&& !Character.isWhitespace(projectStatus.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 if(projectStatus.getCompletedDate()!=null )
		 {

			 Timestamp ts = projectStatus.getCompletedDate();
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
		 
		 
		 
		 
		 if(projectStatus.getUpdatedDate()!=null )
		 {

			 Timestamp ts = projectStatus.getUpdatedDate();
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
		 
		 
		 if(projectStatus.getSupervisorName()!=null&& projectStatus.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectStatus.getSupervisorName()).matches())
		       {
		    	   errors.rejectValue("supervisorName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("supervisorName", "field required");
	     }
		 
		 
		 
		 if(projectStatus.getDescription()!=null&& projectStatus.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(projectStatus.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		 
		 
		 if(!DoubleValidator.getInstance().isValid(""+projectStatus.getDonePercentage()))
		 {
			 errors.rejectValue("donePercentage", "project done percentage must be in double format e.g. 100.00");
		 }
		 
		 
		 if(projectStatus.getSupervisorName()!=null&& projectStatus.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectStatus.getSupervisorName()).matches())
		       {
		    	   errors.rejectValue("supervisorName", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("supervisorName", "field required");
	     }
		 	
	
}
}
