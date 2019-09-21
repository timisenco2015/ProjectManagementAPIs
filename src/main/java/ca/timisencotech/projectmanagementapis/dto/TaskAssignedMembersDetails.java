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
@IdClass(TaskAssignedMembersDetails.TaskAssignedMembersDetailsId.class)
@Table(name = "taskassignedmemberstable",uniqueConstraints=@UniqueConstraint(columnNames={"projectgroupmemberid","supervisortaskid"}))
public class TaskAssignedMembersDetails implements Serializable{
	




	/**
	 * 
	 */
	private static final long serialVersionUID = 5960061536679700058L;




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	

	
	@Column(name = "dateassigned",length=20,nullable = false)
	private Timestamp dateAssigned;

	

	@Column(name = "description",columnDefinition="LONGTEXT")
	private String description;

	
	@Column(name = "isactive",length=5)
	private boolean isActive;
	
	


	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisortaskid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private SupervisorTasksDetails supervisorTasksDetails;

	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectgroupmemberid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectGroupMemberDetails projectGroupMemberDetails;

	
	@OneToMany(mappedBy = "taskAssignedMembersDetails")
	private List<TaskStatusDetails> taskStatusDetails = new ArrayList<TaskStatusDetails>();
	


	@OneToMany(mappedBy = "taskAssignedMembersDetails")
	private List<SelfAppraisalsDetails> selfAppraisalsDetails = new ArrayList<SelfAppraisalsDetails>();
	
	
	
	@OneToMany(mappedBy = "taskAssignedMembersDetails")
	private List<SupervisorAppraisalsDetails> supervisorAppraisalsDetails = new ArrayList<SupervisorAppraisalsDetails>();
	
	@Bean
	public List<SelfAppraisalsDetails> getSelfAppraisalsDetails() {
		return selfAppraisalsDetails;
	}

	@Bean
	public void setSelfAppraisalsDetails(List<SelfAppraisalsDetails> selfAppraisalsDetails) {
		this.selfAppraisalsDetails = selfAppraisalsDetails;
	}

	@Bean
	public List<SupervisorAppraisalsDetails> getSupervisorAppraisalsDetails() {
		return supervisorAppraisalsDetails;
	}

	@Bean
	public void setSupervisorAppraisalsDetails(List<SupervisorAppraisalsDetails> supervisorAppraisalsDetails) {
		this.supervisorAppraisalsDetails = supervisorAppraisalsDetails;
	}

	@Bean
	public Timestamp getDateAssigned() {
		return dateAssigned;
	}

	@Bean
	public void setDateAssigned(Timestamp dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	@Bean
	public String getDescription() {
		return description;
	}

	@Bean
	public void setDescription(String description) {
		this.description = description;
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
	public SupervisorTasksDetails getSupervisorTasksDetails() {
		return supervisorTasksDetails;
	}

	@Bean
	public void setSupervisorTasksDetails(SupervisorTasksDetails supervisorTasksDetails) {
		this.supervisorTasksDetails = supervisorTasksDetails;
	}
	
	@Bean
	public List<TaskStatusDetails> getTaskStatusDetails() {
		return taskStatusDetails;
	}

	@Bean
	public void setTaskStatusDetails(List<TaskStatusDetails> taskStatusDetails) {
		this.taskStatusDetails = taskStatusDetails;
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
	public ProjectGroupMemberDetails getProjectGroupMemberDetails() {
		return projectGroupMemberDetails;
	}

	@Bean
	public void setProjectGroupMemberDetails(ProjectGroupMemberDetails projectGroupMemberDetails) {
		this.projectGroupMemberDetails = projectGroupMemberDetails;
	}


	public String toString()
	{
		return "{projectName:"+supervisorTasksDetails.getTaskDetails().getProjectDetails().getProjectName()+", taskName:"+supervisorTasksDetails.getTaskDetails().getTaskName()+", dateAssigned:"+dateAssigned+", isActive:"+isActive+", assignedBy:"+
				supervisorTasksDetails.getProjectSupervisorsDetails().getUserSignUpDetails().getUserEmail()+", assignedTo:"+projectGroupMemberDetails.getUserSignUpDetails().getUserEmail()+", description:"+description+"}";
	}

	


	public static class TaskAssignedMembersDetailsId implements Serializable {
	  

		/**
		 * 
		 */
		private static final long serialVersionUID = -6679455690092667901L;
		private Long id;
		
		
	}

}
