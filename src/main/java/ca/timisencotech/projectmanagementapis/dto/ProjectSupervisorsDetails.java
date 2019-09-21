package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@IdClass(ProjectSupervisorsDetails.ProjectSupervisorsDetailsId.class)
@Table(name = "projectsupervisorstable",uniqueConstraints=@UniqueConstraint(columnNames= {"projectid","usersignupid"}))

public class ProjectSupervisorsDetails implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -5577479689844875114L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "isactive",length=8, nullable=false)
	private boolean isActive;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectDetails projectDetails;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usersignupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	
	@OneToMany(mappedBy = "projectSupervisorsDetails")
	private List<ProjectGroupDetails> projectGroupDetails = new ArrayList<ProjectGroupDetails>();
	
	
	
	
	@OneToOne(mappedBy = "projectSupervisorsDetails")
	private SupervisorsPrivilegesDetails supervisorsPrivilegesDetails;
	

	
	



	@OneToMany(mappedBy = "projectSupervisorsDetails")
	private List<SupervisorsMembersDetails> supervisorsMembersDetails = new ArrayList<SupervisorsMembersDetails>();
	


	@OneToMany(mappedBy = "projectSupervisorsDetails")
	private List<ProjectStatusDetails> projectStatusDetails = new ArrayList<ProjectStatusDetails>();
	
	
	
	
	public  ProjectSupervisorsDetails()
	{
		
	}
	
	
	@Bean
	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	@Bean
	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Bean
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Bean
	public boolean getIsActive() {
		return isActive;
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
	public SupervisorsPrivilegesDetails getSupervisorsPrivilegesDetails() {
		return supervisorsPrivilegesDetails;
	}

	@Bean
	public void setSupervisorsPrivilegesDetails(SupervisorsPrivilegesDetails supervisorsPrivilegesDetails) {
		this.supervisorsPrivilegesDetails = supervisorsPrivilegesDetails;
	}


	@Bean
	public List<SupervisorsMembersDetails> getSupervisorsMembersDetails() {
		return supervisorsMembersDetails;
	}

	@Bean
	public void setSupervisorsMembersDetails(List<SupervisorsMembersDetails> supervisorsMembersDetails) {
		this.supervisorsMembersDetails = supervisorsMembersDetails;
	}


	@Bean
	public List<ProjectGroupDetails> getProjectGroupDetails() {
		return projectGroupDetails;
	}

	@Bean
	public void setProjectGroupDetails(List<ProjectGroupDetails> projectGroupDetails) {
		this.projectGroupDetails = projectGroupDetails;
	}

	@Bean
	public List<SupervisorsMembersDetails> getSupervisorsMembers() {
		return supervisorsMembersDetails;
	}

	@Bean
	public void setSupervisorsMembers(List<SupervisorsMembersDetails> supervisorsMembersDetails) {
		this.supervisorsMembersDetails = supervisorsMembersDetails;
	}

	@Bean
	public List<ProjectStatusDetails> getProjectStatusDetails() {
		return projectStatusDetails;
	}

	@Bean
	public void setProjectStatusDetails(List<ProjectStatusDetails> projectStatusDetails) {
		this.projectStatusDetails = projectStatusDetails;
	}


	@Override
	public String toString()
	{
		return "{projectName:"+projectDetails.getProjectName()+", supervisorName:"+userSignUpDetails.getUserEmail()+", isActive:"+ isActive+"}";
	}
	
	
	public static class ProjectSupervisorsDetailsId implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -6082880417836480181L;
		private Long id;
	
		
	}
}
