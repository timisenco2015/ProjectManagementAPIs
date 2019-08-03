package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.context.annotation.Bean;



@Entity
@IdClass(UserSignUpDetails.UserLoginDetailsId.class)
@Table(name = "usersignupetailstable",uniqueConstraints=@UniqueConstraint(columnNames="email"))

public class UserSignUpDetails implements Serializable{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8486341599378874546L;


	
	@Id
	@Column(name = "email", unique = true,nullable = false,length=60)
	private String email;
	
	
	@Column(name = "password", nullable = false,length=20)
	private String password;
	
	
	
	@OneToOne(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = false)
	private UserDetails userDetails;
					
	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
	fetch = FetchType.LAZY)
	private List<ProjectDetails> projectDetails = new ArrayList<ProjectDetails>();
			
	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
	fetch = FetchType.LAZY)
	private List<UserLoginDetails> userLoginDetails = new ArrayList<UserLoginDetails>();
			
	
	
	
	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}


	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}


	public  UserSignUpDetails()
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
	

	
	

	
	@Override
	public String toString()
	{
		return "{email:"+email+", password:"+password+"}";
	}
	public static class UserLoginDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private String email;
		
		
	}
}
