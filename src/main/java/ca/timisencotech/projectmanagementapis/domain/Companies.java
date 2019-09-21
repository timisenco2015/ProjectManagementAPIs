package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;





public class Companies implements Serializable{

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5215406433059163710L;


	private String registerBy;
	private String companyName;
	private String address;
	private String city;
	private String stateProvince;
	private String country;
	private String postalCode;
	private String phoneNumber;
	

	
	
	
	
	public Companies()
	{
		
	}
	
	
	@Override
	public String toString()
	{
		return "{ registerBy:"+registerBy+", companyName:"+companyName+", address:"+address+", city:"+city+", stateProvince:"+stateProvince+", country:"+country+"postalCode:"+postalCode+"phoneNumber:"+phoneNumber+" }";
	}
	


	
	public String getRegisterBy() {
		return registerBy;
	}

	
	public void setRegisterBy(String registerBy) {
		this.registerBy = registerBy;
	}

	
	public String getCompanyName() {
		return companyName;
	}

	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	@Bean
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getStateProvince() {
		return stateProvince;
	}

	
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}


	public String getCountry() {
		return country;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getPostalCode() {
		return postalCode;
	}

	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	
	

}


