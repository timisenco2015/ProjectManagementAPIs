package ca.timisencotech.projectmanagementapis.domain;


import java.io.Serializable;



public class StateProvince implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2908557998369563387L;

	
	private int stateProvinceId;
	
	private String stateProvinceName;
	
	private int countryId;
	
	
	public StateProvince()
	{
		
	}
	
	
	
	public int getStateProvinceId()
	{
		return stateProvinceId;
	}
	
	
	public void setStateProvinceId(int stateProvinceId)
	{
		this.stateProvinceId = stateProvinceId;
	}
	
	
	
	public String getStateProvinceName()
	{
		return stateProvinceName;
	}
	
	
	public void setStateProvinceName(String statProvinceName)
	{
		this.stateProvinceName = statProvinceName;
	}
	
	
	public int getCountryId()
	{
		return countryId;
	}
	
	
	public void setCountryId(int countryId)
	{
		this.countryId = countryId;
	}
	
	@Override
	public String toString()
	{
		return "{ stateprovinceId:"+stateProvinceId+", stateprovinceName:"+stateProvinceName+", country id :"+countryId+" }";
	}

}