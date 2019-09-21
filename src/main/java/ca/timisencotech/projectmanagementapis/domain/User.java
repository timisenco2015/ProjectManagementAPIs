package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;





public class User implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5699186061238687978L;

	private String email;
	
	private String middleName;

	private String lastName;
	private String firstName;
	private String phoneNo;	
	private String address;
	private String gender;
	
	public  User()
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
	

	
	
	
	
	public String getMiddleName()
	{
		return middleName;
	}
	
	
	
	public void setMiddleName(String middleName)
	{
		this.middleName =middleName;
	}
	
	
	
	
	public String getLastName()
	{
		return lastName;
	}
	
	
	
	public void setLastName(String lastName)
	{
		this.lastName =lastName;
	}
	
	

	public String getFirstName()
	{
		return firstName;
	}
	
	
	
	public void setFirstName(String firstName)
	{
		this.firstName =firstName;
	}
	
	
	
	public String getUserGender()
	{
		return gender;
	}
	
	
	
	public void setUserGender(String gender)
	{
		this.gender =gender;
	}
	
	
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo =phoneNo;
	}
	
	
	
	
	

	public String getUserAddress()
	{
		return address;
	}
	
	
	public void setUserAddress(String userAddress)
	{
		this.address = userAddress;
	}
	
	@Override
	public String toString()
	{
		return "{email:"+email+", firstName:"+firstName+", middleName:"+middleName+", lastName:"+lastName+ ",  phoneNo:"+phoneNo+", address:"+address+", gender:"+gender+"}";
	}

}
