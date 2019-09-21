package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class UserLogin implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1511269801378625193L;

	private String email;
	
	private String password;

	 private Timestamp loginTime;
	
	
	public  UserLogin()
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
	
	
	
	
	public Timestamp getLoginTime()
	{
		return loginTime;
	}
	
	
	
	public void setLoginTime(Timestamp loginTime)
	{
		this.loginTime =loginTime;
	}
	
	

	
	@Override
	public String toString()
	{
		return "{email:"+email+", password:"+password+", loginTime:"+loginTime+"}";
	}
	
	
}
