package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "statesprovincestable",uniqueConstraints=@UniqueConstraint(columnNames="stateprovinceid"))
@IdClass(StatesProvinces.StatesProvincesId.class)
public class StatesProvinces implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "stateprovinceid",unique = true, nullable = false,length=20)
	private int stateprovinceId;
	
	
	@Column(name = "stateprovincename",unique = true, nullable = false,length=240)
	private String stateprovinceName;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "countryid",referencedColumnName="countryid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Countries countries;
	
	
	@OneToMany(mappedBy = "statesProvinces")
	private List<Cities> cities = new ArrayList<Cities>();
	
	
	
	public StatesProvinces()
	{
		
	}
	
	
	@Bean
	public List<Cities> getCities() {
        return cities;
    }
 
	@Bean
    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }
	
	@Bean
	public Countries getCountries() {
        return countries;
    }
 
	@Bean
    public void setCountries(Countries countries) {
        this.countries = countries;
    }
    
	@Bean
	public int getStateProvinceId()
	{
		return stateprovinceId;
	}
	
	@Bean
	public void setStateProvinceId(int stateProvinceId)
	{
		this.stateprovinceId = stateProvinceId;
	}
	
	
	@Bean
	public String getStateProvinceName()
	{
		return stateprovinceName;
	}
	
	
	@Bean
	public void setStateProvinceName(String statProvinceName)
	{
		this.stateprovinceName = statProvinceName;
	}
	
	@Override
	public String toString()
	{
		return "{stateprovinceId:"+stateprovinceId+", stateprovinceName:"+stateprovinceName+", country:"+countries+" }";
	}
	
	
	public static class StatesProvincesId implements Serializable {
		   
		private static final long serialVersionUID = -7321416499047242338L;
		private int stateprovinceId;
		
	}

}


