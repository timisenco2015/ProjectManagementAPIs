package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;

public class City implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1135408119007698904L;
	private int cityId;
	private String cityName;
	private int stateId;
	
	
	public City()
	{
		
	}
	
	

	public int getCityId()
	{
		return cityId;
	}
	
	
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}
	
	
	public String getCityName()
	{
		return cityName;
	}
	
	
	
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	
	
	

	public int getStateId()
	{
		return stateId;
	}
	
	
	
	public void setStateId(int stateId)
	{
		this.stateId = stateId;
	}
	
	@Override
	public String toString()
	{
		return "{ cityId:"+cityId+", cityName: "+cityName+", stateId:"+stateId+"}";
	}
}
