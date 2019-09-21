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
@IdClass(SupervisorsMembersDetails.SupervisorsMembersId.class)
@Table(name = "supervisorsmemberstable",uniqueConstraints=@UniqueConstraint(columnNames= {"supervisorid","projectgroupmemberid"}))
public class SupervisorsMembersDetails implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6542568807543581970L;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisorid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectSupervisorsDetails projectSupervisorsDetails;

	

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectgroupmemberid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectGroupMemberDetails projectGroupMemberDetails;



	@Bean
	public ProjectSupervisorsDetails getProjectSupervisorsDetails() {
		return projectSupervisorsDetails;
	}



	@Bean
	public void setProjectSupervisorsDetails(ProjectSupervisorsDetails projectSupervisorsDetails) {
		this.projectSupervisorsDetails = projectSupervisorsDetails;
	}



	@Bean
	public ProjectGroupMemberDetails getProjectGroupMemberDetails() {
		return projectGroupMemberDetails;
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
	public void setProjectGroupMemberDetails(ProjectGroupMemberDetails projectGroupMemberDetails) {
		this.projectGroupMemberDetails = projectGroupMemberDetails;
	}
	
	
	



	@Override
	public String toString()
	{
		return "{projectName:"+projectSupervisorsDetails.getProjectDetails().getProjectName()+", supervisorName:"+projectSupervisorsDetails.getUserSignUpDetails().getUserEmail()+", membername:"+ projectGroupMemberDetails.getUserSignUpDetails().getUserEmail()+"}";
	}
	
	
	public static class SupervisorsMembersId implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 2135355238714635984L;
		private Long id;
	
		
	}
}
