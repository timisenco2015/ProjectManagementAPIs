package ca.timisencotech.projectmanagementapis.validation;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;


public class ValidateSupervisorAppraisal implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return SupervisorAppraisals.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupervisorAppraisals supervisorAppraisals = (SupervisorAppraisals) target;
		 // starting from line 23 to line 40 checks for valid email address 
			
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardAPoint()))
		 {
			 errors.rejectValue("standardAPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardBPoint()))
		 {
			 errors.rejectValue("standardBPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardCPoint()))
		 {
			 errors.rejectValue("standardCPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardDPoint()))
		 {
			 errors.rejectValue("standardAPoint", "standardDPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardEPoint()))
		 {
			 errors.rejectValue("standardEPoint", "standardEPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardFPoint()))
		 {
			 errors.rejectValue("standardFPoint", "standardFPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardGPoint()))
		 {
			 errors.rejectValue("standardGPoint", "standardGPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardHPoint()))
		 {
			 errors.rejectValue("standardHPoint", "standardHPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardIPoint()))
		 {
			 errors.rejectValue("standardIPoint", "standardIPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+supervisorAppraisals.getStandardJPoint()))
		 {
			 errors.rejectValue("standardJPoint", "standardJPoint must be in double format e.g. 100.00");
		 }
		
		
		if(supervisorAppraisals.getStandardA()!=null && supervisorAppraisals.getStandardA().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardA().length() && !invalid; i++) {
                if (!Character.isAlphabetic(supervisorAppraisals.getStandardA().charAt(i)))
              		  
                {
                    invalid = true;
                    errors.rejectValue("standardAPoint", "field contains invalid characters");
                   
                }
            }
		 }
		
		else
			 {
				   errors.rejectValue("standardAPoint", "field required");
			 }
		
		
		if(supervisorAppraisals.getStandardB()!=null && supervisorAppraisals.getStandardB().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardB().length() && !invalid; i++) {
               if (!Character.isAlphabetic(supervisorAppraisals.getStandardB().charAt(i)))
             		  
               {
                   invalid = true;
                   errors.rejectValue("standardBPoint", "field contains invalid characters");
                  
               }
           }
		 }
		
		else
			 {
				   errors.rejectValue("standardBPoint", "field required");
			 }
		
		
		if(supervisorAppraisals.getStandardC()!=null && supervisorAppraisals.getStandardC().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardC().length() && !invalid; i++) {
              if (!Character.isAlphabetic(supervisorAppraisals.getStandardC().charAt(i)))
            		  
              {
                  invalid = true;
                  errors.rejectValue("standardCPoint", "field contains invalid characters");
                 
              }
          }
		 }
		
		else
			 {
				   errors.rejectValue("standardCPoint", "field required");
			 }
		
		if(supervisorAppraisals.getStandardD()!=null && supervisorAppraisals.getStandardD().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardD().length() && !invalid; i++) {
              if (!Character.isAlphabetic(supervisorAppraisals.getStandardD().charAt(i)))
            		  
              {
                  invalid = true;
                  errors.rejectValue("standardDPoint", "field contains invalid characters");
                 
              }
          }
		 }
		
		else
			 {
				   errors.rejectValue("standardDPoint", "field required");
			 }
		
		
		if(supervisorAppraisals.getStandardE()!=null && supervisorAppraisals.getStandardE().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardE().length() && !invalid; i++) {
              if (!Character.isAlphabetic(supervisorAppraisals.getStandardE().charAt(i)))
            		  
              {
                  invalid = true;
                  errors.rejectValue("standardEPoint", "field contains invalid characters");
                 
              }
          }
		 }
		
		else
			 {
				   errors.rejectValue("standardEPoint", "field required");
			 }
		
		
		
		if(supervisorAppraisals.getStandardF()!=null && supervisorAppraisals.getStandardF().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardF().length() && !invalid; i++) {
             if (!Character.isAlphabetic(supervisorAppraisals.getStandardF().charAt(i)))
           		  
             {
                 invalid = true;
                 errors.rejectValue("standardFPoint", "field contains invalid characters");
                
             }
         }
		 }
		
		else
			 {
				   errors.rejectValue("standardFPoint", "field required");
			 }
		
		
		
		
		if(supervisorAppraisals.getStandardG()!=null && supervisorAppraisals.getStandardG().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardG().length() && !invalid; i++) {
            if (!Character.isAlphabetic(supervisorAppraisals.getStandardG().charAt(i)))
          		  
            {
                invalid = true;
                errors.rejectValue("standardGPoint", "field contains invalid characters");
               
            }
        }
		 }
		
		else
			 {
				   errors.rejectValue("standardGPoint", "field required");
			 }
		
		
		if(supervisorAppraisals.getStandardH()!=null && supervisorAppraisals.getStandardH().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardH().length() && !invalid; i++) {
           if (!Character.isAlphabetic(supervisorAppraisals.getStandardH().charAt(i)))
         		  
           {
               invalid = true;
               errors.rejectValue("standardHPoint", "field contains invalid characters");
              
           }
       }
		 }
		
		else
			 {
				   errors.rejectValue("standardHPoint", "field required");
			 }
		
		
		
		
		if(supervisorAppraisals.getStandardI()!=null && supervisorAppraisals.getStandardI().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardI().length() && !invalid; i++) {
           if (!Character.isAlphabetic(supervisorAppraisals.getStandardI().charAt(i)))
         		  
           {
               invalid = true;
               errors.rejectValue("standardIPoint", "field contains invalid characters");
              
           }
       }
		 }
		
		else
			 {
				   errors.rejectValue("standardIPoint", "field required");
			 }
		
		
		if(supervisorAppraisals.getStandardJ()!=null && supervisorAppraisals.getStandardJ().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<supervisorAppraisals.getStandardJ().length() && !invalid; i++) {
           if (!Character.isAlphabetic(supervisorAppraisals.getStandardJ().charAt(i)))
         		  
           {
               invalid = true;
               errors.rejectValue("standardJPoint", "field contains invalid characters");
              
           }
       }
		 }
		
		else
			 {
				   errors.rejectValue("standardJPoint", "field required");
			 }
		
		
		
		
		
		
		// starting from line 42 to line 69 checks for valid firstName 
		 if(supervisorAppraisals.getProjectName()!=null && supervisorAppraisals.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorAppraisals.getProjectName().charAt(0)) && !Character.isDigit(supervisorAppraisals.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<supervisorAppraisals.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorAppraisals.getProjectName().charAt(i)) && !Character.isDigit(supervisorAppraisals.getProjectName().charAt(i))&& !Character.isWhitespace(supervisorAppraisals.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 
		 if(supervisorAppraisals.getTaskName()!=null && supervisorAppraisals.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(supervisorAppraisals.getTaskName().charAt(0)) && !Character.isDigit(supervisorAppraisals.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<supervisorAppraisals.getTaskName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(supervisorAppraisals.getTaskName().charAt(i)) && !Character.isDigit(supervisorAppraisals.getTaskName().charAt(i))&& !Character.isWhitespace(supervisorAppraisals.getTaskName().charAt(i)))
		                    		  
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
		 
		 
		 
		 

		 if(supervisorAppraisals.getAppraisedEndDate()!=null )
		 {

			 Timestamp ts = supervisorAppraisals.getAppraisedEndDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("appraisedEndDate", "appraised date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("appraisedEndDate", "field required");
		 }
		 
		 
		 
		 if(supervisorAppraisals.getAppraisedStartDate()!=null )
		 {

			 Timestamp ts = supervisorAppraisals.getAppraisedStartDate();
			 Date date = new Date();
			 date.setTime(ts.getTime());
			 String dateInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
			
	       Pattern pat = Pattern.compile("^\\d{4}[-]?\\d{1,2}[-]?\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
	      
	       if(!pat.matcher(dateInString).matches())
	       {
	       
	    	   errors.rejectValue("appraisedStartDate", "appraised date not in proper time format. e.g. 2019-07-31 12:44:52");
	       }
		 }
		 else
		 {
			 errors.rejectValue("appraisedStartDate", "field required");
		 }
		 
		 
		 
		 if(supervisorAppraisals.getSubordinateMember()!=null&& supervisorAppraisals.getSubordinateMember().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorAppraisals.getSubordinateMember()).matches())
		       {
		    	   errors.rejectValue("subordinateMember", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("subordinateMember", "field required");
	     }
		 
		 if(supervisorAppraisals.getSupervisorName()!=null&& supervisorAppraisals.getSupervisorName().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(supervisorAppraisals.getSupervisorName()).matches())
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
