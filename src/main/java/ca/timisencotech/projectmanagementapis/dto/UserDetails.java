package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "userinformationtable",uniqueConstraints=@UniqueConstraint(columnNames="usersignupid"))

public class UserDetails implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 8832161172544384884L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "middlename", length=20)
	private String middleName;
	
	@Column(name = "lastname", nullable = false,length=20)
	private String lastName;
	
	@Column(name = "firstname", nullable = false,length=20)
	private String firstName;
	
	@Column(name = "phoneno", nullable = false,length=30,unique = true)
	private String phoneNo;
	
	
	
	@Column(name = "address", nullable = false,length=200)
	private String address;
	
	
	@Column(name = "gender", nullable = false,length=15)
	private String gender;
	
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usersignupid",referencedColumnName="id",nullable=false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private UserSignUpDetails userSignUpDetails;
	
	

			
	
	
	public  UserDetails()
	{
		
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
	public String getGender() {
		return gender;
	}



	@Bean
	public void setGender(String gender) {
		this.gender = gender;
	}



	@Bean
	public UserSignUpDetails getUserSignUpDetails() {
		return userSignUpDetails;
	}




	public void setUserSignUpDetails(UserSignUpDetails userSignUpDetails) {
		this.userSignUpDetails = userSignUpDetails;
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
	public Long getId() {
		return id;
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
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	
	@Bean
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo =phoneNo;
	}
	
	
	
	
	@Override
	public String toString()
	{
		return "{email:"+userSignUpDetails.getUserEmail()+", firstName:"+firstName+", middleName:"+middleName+", lastName:"+lastName +", phoneNo:"+phoneNo+", address:"+address+", gender:"+gender+"}";
	}
	
	
	
	public static class UserDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private Long id;
		
		
	}
}
