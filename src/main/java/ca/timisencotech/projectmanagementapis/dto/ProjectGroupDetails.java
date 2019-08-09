package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(ProjectGroupDetails.ProjectGroupDetailsId.class)
@Table(name = "projectgrouptable",uniqueConstraints=@UniqueConstraint(columnNames= {"projectname","groupname"}))
public class ProjectGroupDetails implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 4670424357970764117L;


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
	
	@Column(name = "description",length=400)
	private String description;
	
	@Column(name = "isactive",length=5)
	private boolean isActive;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectname",referencedColumnName="projectname" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectDetails projectDetails;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "createdby",referencedColumnName="email" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;


	
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
	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	@Bean
	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public UserSignUpDetails getUserSignUpDetails() {
		return userSignUpDetails;
	}

	@Bean
	public void setUserSignUpDetails(UserSignUpDetails userSignUpDetails) {
		this.userSignUpDetails = userSignUpDetails;
	}

	@Override
	public String toString()
	{
		return "{ groupName:"+groupName+", groupCreatedBy:"+userSignUpDetails.getUserEmail()+", groupCreatedDate:"+createdDate+", description:"+description
				+", projectName:"+projectDetails.getProjectName()+", createdBy:"+userSignUpDetails.getUserEmail()+"}";
	}

	public static class ProjectGroupDetailsId implements Serializable {
	  
	/**
		 * 
		 */
		private static final long serialVersionUID = -4029284745534436827L;
	private Long id;
		
		
	}

}
