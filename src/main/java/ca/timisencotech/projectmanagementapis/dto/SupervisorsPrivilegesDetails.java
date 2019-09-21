package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@IdClass(SupervisorsPrivilegesDetails.ProjectSupervisorsDetailsId.class)
@Table(name = "supervisorsprivilegestable",uniqueConstraints=@UniqueConstraint(columnNames= {"supervisorid"}))

public class SupervisorsPrivilegesDetails implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -872535525951420334L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	 @Enumerated(EnumType.STRING)
	 @Column(name="privilege",length = 75, nullable = false)
	 private Privileges privileges;
	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisorid",referencedColumnName="id" , nullable = false,insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectSupervisorsDetails projectSupervisorsDetails;
	

	
	
	public  SupervisorsPrivilegesDetails()
	{
		
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
	public Privileges getPrivileges() {
		return privileges;
	}


	@Bean
	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}


	@Bean
	public ProjectSupervisorsDetails getProjectSupervisorsDetails() {
		return projectSupervisorsDetails;
	}


	@Bean
	public void setProjectSupervisorsDetails(ProjectSupervisorsDetails projectSupervisorsDetails) {
		this.projectSupervisorsDetails = projectSupervisorsDetails;
	}



	@Override
	public String toString()
	{
		return "{projectName:"+projectSupervisorsDetails.getProjectDetails().getProjectName()+", supervisorName:"+projectSupervisorsDetails.getUserSignUpDetails().getUserEmail()+", privileges:"+ privileges+"}";
	}
	
	
	public static class ProjectSupervisorsDetailsId implements Serializable {
	
	/**
		 * 
		 */
		private static final long serialVersionUID = 2082455154962147429L;
	private Long id;
	
		
	}
	
	
}
