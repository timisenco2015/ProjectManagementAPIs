
package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
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


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@IdClass(UserLoginDetails.UserLoginDetailsId.class)
@Table(name = "userloginstable")

public class UserLoginDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8493852608064987574L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "password", nullable = false,length=20)
	private String password;
	
	

	@Column(name = "logintime",length=20,nullable = false)
	private Timestamp loginTime;

	
					
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usersignupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	
	


	public  UserLoginDetails()
	{
		
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
	public Long getId() {
		return id;
	}


	@Bean
	public void setId(Long id) {
		this.id = id;
	}



	@Bean
	public String getPassword()
	{
		return password;
	}
	
	
	@Bean
	public void setPassword(String password)
	{
		this.password =password;
	}
	
	
	
	@Bean
	public Timestamp getLoginTime()
	{
		return loginTime;
	}
	
	
	@Bean
	public void setLoginTime(Timestamp loginTime)
	{
		this.loginTime =loginTime;
	}
	
	

	
	@Override
	public String toString()
	{
		return "{email:"+userSignUpDetails.getUserEmail()+", password:"+password+", loginTime:"+loginTime+"}";
	}
	public static class UserLoginDetailsId implements Serializable {
	 
		/**
		 * 
		 */
		private static final long serialVersionUID = -1903673315070721589L;
		private Long id;
		
		
	}
}
