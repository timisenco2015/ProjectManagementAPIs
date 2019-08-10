package ca.timisencotech.projectmanagementapis.validation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;


public class ValidateProjectStatusDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectStatusDetail.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectStatusDetail projectStatusDetail = (ProjectStatusDetail) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectStatusDetail.getProjectName()!=null && projectStatusDetail.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectStatusDetail.getProjectName().charAt(0)) && !Character.isDigit(projectStatusDetail.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectStatusDetail.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectStatusDetail.getProjectName().charAt(i)) && !Character.isDigit(projectStatusDetail.getProjectName().charAt(i))&& !Character.isWhitespace(projectStatusDetail.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 if(projectStatusDetail.getCompletedDate()!=null )
		 {

			 Timestamp ts = projectStatusDetail.getCompletedDate();
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
		 
		 
		 
		 
		 if(projectStatusDetail.getUpdatedDate()!=null )
		 {

			 Timestamp ts = projectStatusDetail.getUpdatedDate();
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
		 
		 
		 
		 if(projectStatusDetail.getDescription()!=null&& projectStatusDetail.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(projectStatusDetail.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		 
		 
		 if(!DoubleValidator.getInstance().isValid(""+projectStatusDetail.getDonePercentage()))
		 {
			 errors.rejectValue("donePercentage", "project done percentage must be in double format e.g. 100.00");
		 }
		 	
	
}
}
