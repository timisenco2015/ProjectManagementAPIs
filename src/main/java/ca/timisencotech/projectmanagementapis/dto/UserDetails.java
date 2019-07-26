package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@IdClass(UserDetails.UserDetailsId.class)
@Table(name = "userinformationtable",uniqueConstraints=@UniqueConstraint(columnNames="email"))

public class UserDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	
	
	@Column(name = "middlename", nullable = false,length=40)
	private String middleName;
	
	@Column(name = "lastname", nullable = false,length=40)
	private String lastName;
	
	@Column(name = "firstname", nullable = false,length=40)
	private String firstName;
	
	@Column(name = "phoneno", nullable = false,length=20,unique = true)
	private String phoneNo;
	
	@Column(name = "countryphonecode", nullable = false,length=8)
	private String phoneCode;
	
	
	@Column(name = "address", nullable = false,length=200)
	private String address;
	
	
	@Column(name = "gender", nullable = false,length=15)
	private String gender;
	
	
	
	
	@Id
	@Column(name = "email",unique = true, nullable = false,length=80)
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "email",referencedColumnName="email" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private UserLoginDetails userLoginDetails;
	
	
	public  UserDetails()
	{
		
	}
	
	@Bean
	public UserLoginDetails getUserLoginDetails()
	{
		return userLoginDetails;
	}
	
	@Bean
	public void setUserLoginDetails(UserLoginDetails userLoginDetails)
	{
		this.userLoginDetails = userLoginDetails;
	}
	

	@Bean
	public String getMiddleName()
	{
		return middleName;
	}
	
	
	@Bean
	public void setMiddleName(String middleName)
	{
		this.middleName =middleName;
	}
	
	
	
	@Bean
	public String getLastName()
	{
		return lastName;
	}
	
	
	@Bean
	public void setLastName(String lastName)
	{
		this.lastName =lastName;
	}
	
	
	
	
	@Bean
	public String getFirstName()
	{
		return firstName;
	}
	
	
	@Bean
	public void setFirstName(String firstName)
	{
		this.firstName =firstName;
	}
	
	
	@Bean
	public String getUserGender()
	{
		return gender;
	}
	
	
	@Bean
	public void setUserGender(String gender)
	{
		this.gender =gender;
	}
	
	
	@Bean
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	
	@Bean
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo =phoneNo;
	}
	
	
	@Bean
	public String getCountryPhoneCode()
	{
		return phoneCode;
	}
	
	
	@Bean
	public void setCountryPhoneCode(String phoneCode)
	{
		this.phoneCode =phoneCode;
	}
	
	
	@Bean
	public String getUserAddress()
	{
		return address;
	}
	
	@Bean
	public void setUserAddress(String userAddress)
	{
		this.address = userAddress;
	}
	
	@Override
	public String toString()
	{
		return "{email:"+userLoginDetails.getUserEmail()+", firstName:"+firstName+", middleName:"+middleName+", lastName:"+lastName+ ", phoneCode:"+phoneCode+", phoneNo:"+phoneNo+", address:"+address+", gender:"+gender+"}";
	}
	
	
	
	public static class UserDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private UserLoginDetails userLoginDetails;
		
		
	}
}
