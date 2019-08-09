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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@IdClass(ProjectSupervisorsDetails.ProjectSupervisorsDetailsId.class)
@Table(name = "projectsupervisorstable",uniqueConstraints=@UniqueConstraint(columnNames= {"projectname","supervisorname"}))

public class ProjectSupervisorsDetails implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3927663064657552021L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "isactive",length=8, nullable=false)
	private boolean isActive;
	

	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectname",referencedColumnName="projectname" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectDetails projectDetails;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisorname",referencedColumnName="email" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	
	
	
	
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
	
	@Override
	public String toString()
	{
		return "{projectName:"+projectDetails.getProjectName()+", supervisorName:"+userSignUpDetails.getUserEmail()+", isActive:"+ isActive+"}";
	}
	
	
	public static class ProjectSupervisorsDetailsId implements Serializable {
	

		/**
		 * 
		 */
		private static final long serialVersionUID = -590022180205389649L;
		private Long id;
	
		
	}
}
