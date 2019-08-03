package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;



public class UserSignUpDetail implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8700089798623450175L;

	private String email;
	
	private String password;

	
	
	public  UserSignUpDetail()
	{
		
	}
	
	

	
	
	public String getUserEmail()
	{
		return email;
	}
	
	
	public void setUserEmail(String userEmail)
	{
		this.email = userEmail;
	}
	

	
	
	
	
	public String getPassword()
	{
		return password;
	}
	
	
	
	public void setPassword(String password)
	{
		this.password =password;
	}
	


	
	@Override
	public String toString()
	{
		return "{email:"+email+", password:"+password+"}";
	}
	
	
}
