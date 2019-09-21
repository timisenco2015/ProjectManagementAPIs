package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(ProjectGroupDetails.ProjectGroupDetailsId.class)
@Table(name = "projectgrouptable",uniqueConstraints=@UniqueConstraint(columnNames= {"supervisorid","groupname"}))
public class ProjectGroupDetails implements Serializable{
	
	



	/**
	 * 
	 */
	private static final long serialVersionUID = -1466974099067589495L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "groupname", nullable = false,length=20)
	private String groupName;
	
	
	@Column(name = "createddate", length=20,nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "description",columnDefinition="LONGTEXT")
	private String description;
	
	@Column(name = "isactive",length=5)
	private boolean isActive;


	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisorid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectSupervisorsDetails projectSupervisorsDetails;
	
	
	@OneToMany(mappedBy = "projectGroupDetails")
	private List<ProjectGroupMemberDetails> projectGroupMemberDetails = new ArrayList<ProjectGroupMemberDetails>();
	


	
	@Bean
	public String getGroupName() {
		return groupName;
	}

	@Bean
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	

	@Bean
	public Timestamp getGroupCreatedDate() {
		return createdDate;
	}

	@Bean
	public void setGroupCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Bean
	public String getDescription() {
		return description;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Bean
	public void setDescription(String description) {
		this.description = description;
	}

	


	@Bean
	public ProjectSupervisorsDetails getProjectSupervisorsDetails() {
		return projectSupervisorsDetails;
	}

	@Bean
	public void setProjectSupervisorsDetails(ProjectSupervisorsDetails projectSupervisorsDetails) {
		this.projectSupervisorsDetails = projectSupervisorsDetails;
	}

	@Bean
	public List<ProjectGroupMemberDetails> getProjectGroupMemberDetails() {
		return projectGroupMemberDetails;
	}

	@Bean
	public void setProjectGroupMemberDetails(List<ProjectGroupMemberDetails> projectGroupMemberDetails) {
		this.projectGroupMemberDetails = projectGroupMemberDetails;
	}

	@Override
	public String toString()
	{
		return "{ groupName:"+groupName+", createdBy:"+projectSupervisorsDetails.getUserSignUpDetails().getUserEmail()+",createdDate:"+createdDate+", description:"+description
				+", projectName:"+projectSupervisorsDetails.getProjectDetails().getProjectName()+"isActive:"+isActive+"}";
	}

	public static class ProjectGroupDetailsId implements Serializable {
	  
	/**
		 * 
		 */
		private static final long serialVersionUID = -245396996019051145L;
	private Long id;
		
		
	}

}
