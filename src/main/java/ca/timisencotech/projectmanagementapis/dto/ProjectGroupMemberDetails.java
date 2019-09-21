package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
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
@IdClass(ProjectGroupMemberDetails.ProjectGroupMemberDetailsId.class)
@Table(name = "projectgroupmemberstable",uniqueConstraints=@UniqueConstraint(columnNames= {"projectgroupid","usersignupid"}))
public class ProjectGroupMemberDetails implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1272705903517099155L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;


	@Column(name = "isactive",length=5)
	private boolean isActive;

	
	@Column(name ="activitiesupdate",columnDefinition="LONGTEXT", nullable = false)
	private String activitiesUpdate;
	 

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usersignupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	@OneToMany(mappedBy = "projectGroupMemberDetails")
	private List<SupervisorsMembersDetails> supervisorsMembersDetails = new ArrayList<SupervisorsMembersDetails>();
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "projectgroupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectGroupDetails projectGroupDetails;
	
	
	
	@OneToMany(mappedBy = "projectGroupMemberDetails")
	private List<TaskAssignedMembersDetails> taskAssignedMembersDetails = new ArrayList<TaskAssignedMembersDetails>();
	
	
	

	@Bean
	public ProjectGroupDetails getProjectGroupDetails() {
		return projectGroupDetails;
	}

	@Bean
	public void setProjectGroupDetails(ProjectGroupDetails projectGroupDetails) {
		this.projectGroupDetails = projectGroupDetails;
	}



	

	@Bean
	public boolean getIsActive() {
		return isActive;
	}

	@Bean
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
	public String getActivitiesUpdate() {
		return activitiesUpdate;
	}

	@Bean
	public void setActivitiesUpdate(String activitiesupdate) {
		this.activitiesUpdate = activitiesupdate;
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
	public List<SupervisorsMembersDetails> getSupervisorsMembers() {
		return supervisorsMembersDetails;
	}

	@Bean
	public void setSupervisorsMembers(List<SupervisorsMembersDetails> supervisorsMembersDetails) {
		this.supervisorsMembersDetails = supervisorsMembersDetails;
	}

	@Bean
	public List<TaskAssignedMembersDetails> getTaskAssignedMembersDetails() {
		return taskAssignedMembersDetails;
	}

	@Bean
	public void setTaskAssignedMembersDetails(List<TaskAssignedMembersDetails> taskAssignedMembersDetails) {
		this.taskAssignedMembersDetails = taskAssignedMembersDetails;
	}

	@Override
	public String toString()
	{
		return "{ groupName:"+projectGroupDetails.getGroupName()+", projectName:"+projectGroupDetails.getProjectSupervisorsDetails().getProjectDetails().getProjectName()+", memberName:"+userSignUpDetails.getUserEmail()+", activitiesUpdate:"+activitiesUpdate+", isActive:"+isActive+"}";
	}
	
	

	public static class ProjectGroupMemberDetailsId implements Serializable {
	  
	/**
		 * 
		 */
		private static final long serialVersionUID = 4655486658847362416L;
	private Long id;
		
		
	}

}
