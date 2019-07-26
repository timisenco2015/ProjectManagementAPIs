package ca.timisencotech.projectmanagementapis.exception;

import java.util.List;

import org.json.JSONObject;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ValidationError {
	

	private JSONObject messageOBject=null;

	
	public ValidationError()
	{
		messageOBject = new JSONObject();
	}
	
	public void setErrorStatus(String status)
	{
		messageOBject.put("errorStatus", status);
	}
	
	public void setMessage(String message)
	{
		messageOBject.put("message", message);
		
	}
	
	public void setAllErrorObject(List<ObjectError> ObjectErrorList)
	{
		
		for(ObjectError obj:ObjectErrorList)
		{
			FieldError fieldErrorObject = (FieldError)obj;
			messageOBject.put(fieldErrorObject.getField(), fieldErrorObject.getCode());	
		}
		
	}
	
	

	
	
	public String getMessageObject()
	{
		return messageOBject.toString();
	}
	
}
