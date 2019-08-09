package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "citiestable",uniqueConstraints=@UniqueConstraint(columnNames="cityid"))
@IdClass(Cities.CitiesId.class)
public class Cities implements Serializable{

	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 9120262668429783082L;



	@Id
	@Column(name = "cityid",unique = true, nullable = false,length=10)
	private int cityId;
	
	
	
	@Column(name = "cityname",unique = true, nullable = false,length=60 )
	private String cityName;
	

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "stateprovinceid",referencedColumnName="stateprovinceid" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private StatesProvinces statesProvinces;
	
	

	public Cities()
	{
		
	}
	
	
	@Bean
	public StatesProvinces getStatesProvinces() {
        return statesProvinces;
    }
 
	@Bean
    public void setStatesProvinces(StatesProvinces statesProvinces) {
        this.statesProvinces = statesProvinces;
    }
	@Bean
	public int getCityId()
	{
		return cityId;
	}
	
	@Bean
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}
	
	@Bean
	public String getCityName()
	{
		return cityName;
	}
	
	
	@Bean
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}
	
	
	
	
	@Override
	public String toString()
	{
		return "{ cityId:"+cityId+", cityName: "+cityName+", statesProvinces:"+statesProvinces+"}";
	}
	
	public static class CitiesId implements Serializable {
		   
		/**
		 * 
		 */
		private static final long serialVersionUID = 1061770618410305279L;
		private int cityId;
		
	}

}


