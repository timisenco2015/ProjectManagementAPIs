package ca.timisencotech.projectmanagementapis.exception;

import java.util.List;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import ca.timisencotech.projectmanagementapis.validation.CustomJSONObject;

public class ValidationError extends ErrorObject {
	

	private CustomJSONObject customJSONObject=null;

	
	public ValidationError()
	{
		customJSONObject = new CustomJSONObject();
	}
	
	public void setErrorStatus(String status)
	{
		customJSONObject.put("errorStatus", status);
	}
	
	public void setMessage(String message)
	{
		customJSONObject.put("message", message);
		
	}
	
	public void setAllErrorObject(List<ObjectError> ObjectErrorList)
	{
		
		for(ObjectError obj:ObjectErrorList)
		{
			FieldError fieldErrorObject = (FieldError)obj;
			customJSONObject.put(fieldErrorObject.getField(), fieldErrorObject.getCode());	
		}
		
	}
	
	
	public CustomJSONObject getMessageObject()
	{
		return customJSONObject;
	}
	
	/*
	public String getStringMessageObject()
	{
		return messageOBject.toString();
	}
	*/
	
}
