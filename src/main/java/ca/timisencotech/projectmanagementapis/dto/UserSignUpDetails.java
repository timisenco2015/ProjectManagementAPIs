package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.context.annotation.Bean;




@Entity
@IdClass(UserSignUpDetails.UserSignUpDetailsId.class)
@Table(name = "usersignuptable",uniqueConstraints=@UniqueConstraint(columnNames= {"email"}))

public class UserSignUpDetails implements Serializable{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8486341599378874546L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "email", nullable = false,length=50)
	private String email;
	
	
	@Column(name = "password", nullable = false,length=20)
	private String password;
	

	@OneToMany(mappedBy = "userSignUpDetails")
	private List<TaskDetails> taskDetails = new ArrayList<TaskDetails>();
	
	

	

	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<ProjectDetails> projectDetails = new ArrayList<ProjectDetails>();
			
	
	
	@OneToOne(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = false)
	private UserDetails userDetails;
					
		
	
	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
	fetch = FetchType.LAZY)
	private List<UserLoginDetails> userLoginDetails = new ArrayList<UserLoginDetails>();
		
	

	
	
	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<ProjectSupervisorsDetails> projectSupervisorsDetails = new ArrayList<ProjectSupervisorsDetails>();
	
	
	@OneToMany(mappedBy = "userSignUpDetails")
	private List<ProjectGroupMemberDetails> projectGroupMemberDetails = new ArrayList<ProjectGroupMemberDetails>();
	
	@OneToMany(mappedBy = "userSignUpDetails", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<CompaniesDetails> companiesDetails = new ArrayList<CompaniesDetails>();
		

	public  UserSignUpDetails()
	{
		
	}
	

	
	
	@Bean
	public List<CompaniesDetails> getCompaniesDetails() {
		return companiesDetails;
	}


	@Bean
	public void setCompaniesDetails(List<CompaniesDetails> companiesDetails) {
		this.companiesDetails = companiesDetails;
	}



	@Bean
	public List<ProjectGroupMemberDetails> getProjectGroupMemberDetails() {
		return projectGroupMemberDetails;
	}
	
	
	

	@Bean
	public void setProjectGroupMemberDetails(List<ProjectGroupMemberDetails> projectGroupMemberDetails) {
		this.projectGroupMemberDetails = projectGroupMemberDetails;
	}
	
	
	@Bean
	public List<TaskDetails> getTaskDetails() {
		return taskDetails;
	}



	@Bean
	public void setTaskDetails(List<TaskDetails> taskDetails) {
		this.taskDetails = taskDetails;
	}
	



	@Bean
	public Long getId() {
		return id;
	}








	@Bean
	public List<UserLoginDetails> getUserLoginDetails() {
		return userLoginDetails;
	}

	@Bean
	public void setUserLoginDetails(List<UserLoginDetails> userLoginDetails) {
		this.userLoginDetails = userLoginDetails;
	}

	@Bean
	public List<ProjectSupervisorsDetails> getProjectSupervisorsDetails() {
		return projectSupervisorsDetails;
	}

	@Bean
	public void setProjectSupervisorsDetails(List<ProjectSupervisorsDetails> projectSupervisorsDetails) {
		this.projectSupervisorsDetails = projectSupervisorsDetails;
	}

	@Bean
	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	@Bean
	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}
	

	
	
	@Bean
	public String getUserEmail()
	{
		return email;
	}
	
	@Bean
	public void setUserEmail(String email)
	{
		this.email = email;
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
	public static class UserSignUpDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7321416499047242338L;

		private Long id;
		
		
	}
}
