package ca.timisencotech.projectmanagementapis.validation;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.DoubleValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;


public class ValidateSelfAppraisal implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		  return SelfAppraisals.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SelfAppraisals selfAppraisals = (SelfAppraisals) target;
		 // starting from line 23 to line 40 checks for valid email address 
			
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardAPoint()))
		 {
			 errors.rejectValue("standardAPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardBPoint()))
		 {
			 errors.rejectValue("standardBPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardCPoint()))
		 {
			 errors.rejectValue("standardCPoint", "standardAPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardDPoint()))
		 {
			 errors.rejectValue("standardAPoint", "standardDPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardEPoint()))
		 {
			 errors.rejectValue("standardEPoint", "standardEPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardFPoint()))
		 {
			 errors.rejectValue("standardFPoint", "standardFPoint must be in double format e.g. 100.00");
		 }
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardGPoint()))
		 {
			 errors.rejectValue("standardGPoint", "standardGPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardHPoint()))
		 {
			 errors.rejectValue("standardHPoint", "standardHPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardIPoint()))
		 {
			 errors.rejectValue("standardIPoint", "standardIPoint must be in double format e.g. 100.00");
		 }
		
		
		if(!DoubleValidator.getInstance().isValid(""+selfAppraisals.getStandardJPoint()))
		 {
			 errors.rejectValue("standardJPoint", "standardJPoint must be in double format e.g. 100.00");
		 }
		
		
		if(selfAppraisals.getStandardA()!=null && selfAppraisals.getStandardA().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardA().length() && !invalid; i++) {
                if (!Character.isAlphabetic(selfAppraisals.getStandardA().charAt(i)))
              		  
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
		
		
		if(selfAppraisals.getStandardB()!=null && selfAppraisals.getStandardB().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardB().length() && !invalid; i++) {
               if (!Character.isAlphabetic(selfAppraisals.getStandardB().charAt(i)))
             		  
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
		
		
		if(selfAppraisals.getStandardC()!=null && selfAppraisals.getStandardC().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardC().length() && !invalid; i++) {
              if (!Character.isAlphabetic(selfAppraisals.getStandardC().charAt(i)))
            		  
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
		
		if(selfAppraisals.getStandardD()!=null && selfAppraisals.getStandardD().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardD().length() && !invalid; i++) {
              if (!Character.isAlphabetic(selfAppraisals.getStandardD().charAt(i)))
            		  
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
		
		
		if(selfAppraisals.getStandardE()!=null && selfAppraisals.getStandardE().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardE().length() && !invalid; i++) {
              if (!Character.isAlphabetic(selfAppraisals.getStandardE().charAt(i)))
            		  
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
		
		
		
		if(selfAppraisals.getStandardF()!=null && selfAppraisals.getStandardF().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardF().length() && !invalid; i++) {
             if (!Character.isAlphabetic(selfAppraisals.getStandardF().charAt(i)))
           		  
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
		
		
		
		
		if(selfAppraisals.getStandardG()!=null && selfAppraisals.getStandardG().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardG().length() && !invalid; i++) {
            if (!Character.isAlphabetic(selfAppraisals.getStandardG().charAt(i)))
          		  
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
		
		
		if(selfAppraisals.getStandardH()!=null && selfAppraisals.getStandardH().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardH().length() && !invalid; i++) {
           if (!Character.isAlphabetic(selfAppraisals.getStandardH().charAt(i)))
         		  
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
		
		
		
		
		if(selfAppraisals.getStandardI()!=null && selfAppraisals.getStandardI().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardI().length() && !invalid; i++) {
           if (!Character.isAlphabetic(selfAppraisals.getStandardI().charAt(i)))
         		  
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
		
		
		if(selfAppraisals.getStandardJ()!=null && selfAppraisals.getStandardJ().length()>0)
		 {
			boolean invalid = false;
		    for(int i=0; i<selfAppraisals.getStandardJ().length() && !invalid; i++) {
           if (!Character.isAlphabetic(selfAppraisals.getStandardJ().charAt(i)))
         		  
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
		 if(selfAppraisals.getProjectName()!=null && selfAppraisals.getProjectName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(selfAppraisals.getProjectName().charAt(0)) && !Character.isDigit(selfAppraisals.getProjectName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<selfAppraisals.getProjectName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(selfAppraisals.getProjectName().charAt(i)) && !Character.isDigit(selfAppraisals.getProjectName().charAt(i))&& !Character.isWhitespace(selfAppraisals.getProjectName().charAt(i)))
		                    		  
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
		 
		 
		 
		 
		 if(selfAppraisals.getTaskName()!=null && selfAppraisals.getTaskName().length()>0)
		 {
		      
			 if (!Character.isWhitespace(selfAppraisals.getTaskName().charAt(0)) && !Character.isDigit(selfAppraisals.getTaskName().charAt(0)))
			 {
			 		boolean invalid = false;
		            
		                  for(int i=0; i<selfAppraisals.getTaskName().length() && !invalid; i++) {
		                      if (!Character.isAlphabetic(selfAppraisals.getTaskName().charAt(i)) && !Character.isDigit(selfAppraisals.getTaskName().charAt(i))&& !Character.isWhitespace(selfAppraisals.getTaskName().charAt(i)))
		                    		  
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
		 
		 
		 
		 

		 if(selfAppraisals.getAppraisedEndDate()!=null )
		 {

			 Timestamp ts = selfAppraisals.getAppraisedEndDate();
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
		 
		 
		 
		 if(selfAppraisals.getAppraisedStartDate()!=null )
		 {

			 Timestamp ts = selfAppraisals.getAppraisedStartDate();
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
		 
		 
		 
		 if(selfAppraisals.getSubordinateMember()!=null&& selfAppraisals.getSubordinateMember().length()>0)
	     {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
			 
			 Pattern pat = Pattern.compile(emailRegex);
		       if(!pat.matcher(selfAppraisals.getSubordinateMember()).matches())
		       {
		    	   errors.rejectValue("subordinateMember", "email address is invalid");
		       }
	     }
		 else
		 {
			 errors.rejectValue("subordinateMember", "field required");
	     }
		 

}
}
