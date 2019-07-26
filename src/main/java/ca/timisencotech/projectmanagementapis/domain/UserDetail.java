package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;





public class UserDetail implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
	private String email;
	
	private String middleName;

	private String lastName;
	private String firstName;
	private String phoneNo;	
	private String phoneCode;
	private String address;
	private String gender;
	
	public  UserDetail()
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
	
	
	public String getCountryPhoneCode()
	{
		return phoneCode;
	}
	
	
	public void setCountryPhoneCode(String phoneCode)
	{
		this.phoneCode =phoneCode;
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
		return "{email:"+email+", firstName:"+firstName+", middleName:"+middleName+", lastName:"+lastName+ ", phoneCode:"+phoneCode+", phoneNo:"+phoneNo+", address:"+address+", gender:"+gender+"}";
	}
	public static class UserDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private String email;
		
		
	}
}
