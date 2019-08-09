package ca.timisencotech.projectmanagementapis.validation;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;



public class ValidateProjectGroupDetails implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return ProjectGroupDetail.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProjectGroupDetail projectGroupDetail = (ProjectGroupDetail) target;
		 // starting from line 23 to line 40 checks for valid email address 

		// starting from line 42 to line 69 checks for valid firstName 
		 if(projectGroupDetail.getProjectName()!=null && projectGroupDetail.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(projectGroupDetail.getProjectName().charAt(0)) && !Character.isDigit(projectGroupDetail.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<projectGroupDetail.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(projectGroupDetail.getProjectName().charAt(i)) && !Character.isDigit(projectGroupDetail.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 if(projectGroupDetail.getDescription()!=null&& projectGroupDetail.getDescription().length()>0)
		 {
			 if (!Character.isWhitespace(projectGroupDetail.getDescription().charAt(0)))
			 {
				 
			 }
			 else 
			 {
				 errors.rejectValue("description", "project description must start with a letter e.g. 'A', 'a'");
			 }
			
		 }
		 
		 
		 if(projectGroupDetail.getCreatedBy()!=null&& projectGroupDetail.getCreatedBy().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(projectGroupDetail.getCreatedBy()).matches())
		       {
		    	   errors.rejectValue("createdBy", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("createdBy", "field required");
	     }
		 
		 
		 
		 if(projectGroupDetail.getCreatedDate()!=null )
		 {

			 Timestamp ts = projectGroupDetail.getCreatedDate();
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
		 
		 
		 
		 if( projectGroupDetail.getGroupName()!=null &&  projectGroupDetail.getGroupName().length()>0)
		 {
		      
			 if (!Character.isWhitespace( projectGroupDetail.getGroupName().charAt(0)) && !Character.isDigit( projectGroupDetail.getGroupName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i< projectGroupDetail.getGroupName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic( projectGroupDetail.getGroupName().charAt(i)) && !Character.isDigit( projectGroupDetail.getGroupName().charAt(i)))
		                    		  
		                      {
		                          invalid = true;
		                          errors.rejectValue("groupName", "field contains invalid characters");
		                         
		                      }
		                  }
		               
			 }
			 else 
			 {
				 errors.rejectValue("groupName", "project name must start with a letter e.g. 'A', 'a'");
			 }
	       }
		   else
		   {
			   errors.rejectValue("groupName", "field required");
		   }
		 
	
		 if ((""+projectGroupDetail.getIsActive() != "true" && ""+projectGroupDetail.getIsActive() != "1") || (""+projectGroupDetail.getIsActive() != "false" && ""+projectGroupDetail.getIsActive() != "0"))
		 {
			 errors.rejectValue("isActive", "field required");
		 }
	}
}
