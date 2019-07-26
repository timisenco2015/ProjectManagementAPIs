package ca.timisencotech.projectmanagementapis.domain;


import java.io.Serializable;




public class Country implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int countryId;
	

	private String countryShortCode;
	

	private String countryName;
	
	

	private String phoneCode;
	
	
	public Country()
	{
		
	}
	
	
	
	public int getCountryId()
	{
		return countryId;
	}
	
	
	public void setCountryId(int countryId)
	{
		this.countryId = countryId;
	}
	
	
	
	public String getCountryShortCode()
	{
		return countryShortCode;
	}
	
	
	public void setCountryShortCode(String countryShortCode)
	{
		this.countryShortCode = countryShortCode;
	}
	
	
	
	public String getCountryName()
	{
		return countryName;
	}
	
	
	
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	
	
	public String getphoneCode()
	{
		return phoneCode;
	}
	
	
	public void setPhoneCode(String phoneCode)
	{
		this.phoneCode = phoneCode;
	}
	

	@Override
	public String toString()
	{
		return "{ countryId:"+countryId+", countryName:"+countryName+", countryShortCode:"+countryShortCode+", phoneCode:"+phoneCode+" }";
	}
	

}


