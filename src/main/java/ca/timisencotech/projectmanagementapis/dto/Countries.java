package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;



@Entity
@Table(name = "countriestable",uniqueConstraints=@UniqueConstraint(columnNames="countryid"))
@IdClass(Countries.CountriesId.class)
public class Countries implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5484297773439503593L;

	@Id
	@Column(name = "countryid",unique = true, nullable = false,length=10)
	private int countryId;
	
	@Column(name = "sortname",unique = true, nullable = false,length=10)
	private String countryShortCode;
	
	@Column(name = "countryname" ,unique = true, nullable = false,length=60)
	private String countryName;
	
	
	
	@Column(name = "phonecode", nullable = false,length=8)
	private String phoneCode;
	
	
	@OneToMany(mappedBy = "countries")
	private List<StatesProvinces> statesProvinces = new ArrayList<StatesProvinces>();
	
	
	
	public Countries()
	{
		
	}
	
	@Bean
	public List<StatesProvinces> getCities() {
        return statesProvinces;
    }
 
	@Bean
    public void setStatesProvinces(List<StatesProvinces> statesProvinces) {
        this.statesProvinces = statesProvinces;
    }
	
	
	@Bean
	public int getCountryId()
	{
		return countryId;
	}
	
	@Bean
	public void setCountryId(int countryid)
	{
		this.countryId = countryid;
	}
	
	
	@Bean
	public String getCountryShortCode()
	{
		return countryShortCode;
	}
	
	@Bean
	public void setCountryShortCode(String countryShortCode)
	{
		this.countryShortCode = countryShortCode;
	}
	
	
	@Bean
	public String getCountryName()
	{
		return countryName;
	}
	
	
	@Bean
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	
	@Bean
	public String getphoneCode()
	{
		return phoneCode;
	}
	
	@Bean
	public void setPhoneCode(String phoneCode)
	{
		this.phoneCode = phoneCode;
	}
	
	

	@Override
	public String toString()
	{
		return "{ countryId:"+countryId+", countryName:"+countryName+", countryShortCode:"+countryShortCode+", phoneCode:"+phoneCode+" }";
	}
	
	public static class CountriesId implements Serializable {
		   
		/**
		 * 
		 */
		private static final long serialVersionUID = 5873692870547986205L;
		private int countryId;
		
	}
	
	

}


