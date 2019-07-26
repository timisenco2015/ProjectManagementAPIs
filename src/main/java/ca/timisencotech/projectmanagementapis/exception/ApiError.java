package ca.timisencotech.projectmanagementapis.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	
	 private String status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	  

	 
	  

	   ApiError(String status, String message) {
	     
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
		   return "Time::- "+timestamp+" \n"+"Status::- "+status+" \n"+"Message::- "+message;
	   }

	 
}
