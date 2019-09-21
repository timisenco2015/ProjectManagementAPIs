package ca.timisencotech.projectmanagementapis.exception;

import java.time.LocalDateTime;


public class ApiError extends ErrorObject {
	
	 private String status;
	   private LocalDateTime timestamp;
	   private String message;
	  

	 
	  

	   public ApiError(String status, String message) {
	     
	       this.status = status;
	       this.message = message;
	       timestamp = LocalDateTime.now();
	       
	   }
	   
	   public String getMessage()
	   {
		   return message;
	   }
	   
	   public String getStatus()
	   {
		   return status;
	   }
	   
	   public LocalDateTime getTimeStamp()
	   {
		   return timestamp;
	   }
	   
	 @Override
	 public String toString()
	 {
	
		return "status: "+status+", message:"+message+", timestamp:"+timestamp;		 
	}
	   
	
	 
}
