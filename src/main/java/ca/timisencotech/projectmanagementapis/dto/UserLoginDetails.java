package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@IdClass(UserLoginDetails.UserLoginDetailsId.class)
@Table(name = "userlogindetailstable",uniqueConstraints=@UniqueConstraint(columnNames="email"))

public class UserLoginDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	@Id
	@Column(name = "email",unique = true, nullable = false,length=50)
	private String email;
	
	
	@Column(name = "password", nullable = false,length=20)
	private String password;
	
	@Column(name = "logintime", nullable = false,length=100)
	private Timestamp loginTime;
	
	@OneToOne(mappedBy = "userLoginDetails", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	private UserDetails userDetails;
					
	
	
	public  UserLoginDetails()
	{
		
	}
	
	
	@Bean
	public String getUserEmail()
	{
		return email;
	}
	
	@Bean
	public void setUserEmail(String userEmail)
	{
		this.email = userEmail;
	}
	
	
	@Bean
	public UserDetails getUserDetails()
	{
		return userDetails;
	}
	
	@Bean
	public void setUserDetails(UserDetails userDetails)
	{
		this.userDetails = userDetails;
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
		return "{email:"+email+", password:"+password+", loginTime:"+loginTime+"}";
	}
	public static class UserLoginDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private String email;
		
		
	}
}
