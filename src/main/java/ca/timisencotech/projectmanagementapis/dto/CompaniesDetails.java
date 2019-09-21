package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "companiestable")
@IdClass(CompaniesDetails.CompaniesDetailsId.class)
public class CompaniesDetails implements Serializable{

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6613292184332932247L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	
	
	@Column(name = "companyname", nullable = false,length=50,unique = true)
	private String companyName;
	
	
	@Column(name = "companyaddress", nullable = false,length=150)
	private String address;
	
	@Column(name = "companycity" , nullable = false,length=60)
	private String city;
	
	
	
	@Column(name = "companystateprovince", nullable = false,length=50)
	private String stateProvince;
	
	@Column(name = "companycountry", nullable = false,length=50)
	private String country;
	
	@Column(name = "postalcode", nullable = false,length=15)
	private String postalCode;
	
	@Column(name = "phonenumber", nullable = false,length=30)
	private String phoneNumber;
	

		
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usersignupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	public CompaniesDetails()
	{
		
	}
	
	
	@Override
	public String toString()
	{
		return "{ registerBy:"+userSignUpDetails.getUserEmail()+", companyName:"+companyName+", address:"+address+", city:"+city+", stateProvince:"+stateProvince+", country:"+country+"postalCode:"+postalCode+"phoneNumber:"+phoneNumber+" }";
	}
	
	public static class CompaniesDetailsId implements Serializable {
		   
		/**
		 * 
		 */
		private static final long serialVersionUID = 1624366002799358562L;
		
		private Long id;
		
	}

	
	@Bean
	public Long getId() {
		return id;
	}

	@Bean
	public void setId(Long id) {
		this.id = id;
	}


	@Bean
	public UserSignUpDetails getUserSignUpDetails() {
		return userSignUpDetails;
	}

	@Bean
	public void setUserSignUpDetails(UserSignUpDetails userSignUpDetails) {
		this.userSignUpDetails = userSignUpDetails;
	}


	@Bean
	public String getCompanyName() {
		return companyName;
	}

	@Bean
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Bean
	public String getAddress() {
		return address;
	}

	@Bean
	public void setAddress(String address) {
		this.address = address;
	}

	@Bean
	public String getCity() {
		return city;
	}

	@Bean
	public void setCity(String city) {
		this.city = city;
	}

	@Bean
	public String getStateProvince() {
		return stateProvince;
	}

	@Bean
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@Bean
	public String getCountry() {
		return country;
	}

	@Bean
	public void setCountry(String country) {
		this.country = country;
	}

	@Bean
	public String getPostalCode() {
		return postalCode;
	}

	@Bean
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Bean
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Bean
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	
	

}


