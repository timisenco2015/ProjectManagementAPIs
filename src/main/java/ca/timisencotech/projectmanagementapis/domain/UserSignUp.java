package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;



public class UserSignUp implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8700089798623450175L;

	private String email;
	
	private String password;

	
	
	public  UserSignUp()
	{
		
	}
	
	

	
	
	public String getEmail()
	{
		return email;
	}
	
	
	public void setEmail(String userEmail)
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
