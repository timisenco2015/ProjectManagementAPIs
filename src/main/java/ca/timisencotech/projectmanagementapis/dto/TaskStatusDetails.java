package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;

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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@IdClass(TaskStatusDetails.TaskStatusDetailsId.class)
@Table(name = "taskstatustable")

public class TaskStatusDetails implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = -4738413005063027906L;


	@Bean
	public Long getId() {
		return id;
	}

	
	@Bean
	public void setId(Long id) {
		this.id = id;
	}

	@Bean
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	@Bean
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
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
	public double getDonePercentage() {
		return donePercentage;
	}

	@Bean
	public void setDonePercentage(double donePercentage) {
		this.donePercentage = donePercentage;
	}

	@Bean
	public Timestamp getCompletedDate() {
		return completedDate;
	}

	@Bean
	public void setCompletedDate(Timestamp completedDate) {
		this.completedDate = completedDate;
	}

	@Bean
	public TaskAssignedMembersDetails getTaskAssignedMembersDetails() {
		return taskAssignedMembersDetails;
	}
	@Bean
	public void setTaskAssignedMembersDetails(TaskAssignedMembersDetails taskAssignedMembersDetails) {
		this.taskAssignedMembersDetails = taskAssignedMembersDetails;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	
	@Column(name = "updateddate", length=20,nullable=false)
	private Timestamp updatedDate;
	
	
	@Column(name = "description", columnDefinition="LONGTEXT",nullable=false)
	private String description;
	
	@Column(name = "donepercentage", precision=16, scale=2,nullable=false)
	private double donePercentage;
	
	
	@Column(name = "completeddate", length=20)
	private Timestamp completedDate;
	
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="taskassignedmembersid",referencedColumnName="id", nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TaskAssignedMembersDetails taskAssignedMembersDetails;
	
	
	@Override
	public String toString()
	{
		return "{projectName:"+taskAssignedMembersDetails.getSupervisorTasksDetails().getTaskDetails().getProjectDetails().getProjectName()+", taskname"+taskAssignedMembersDetails.getSupervisorTasksDetails().getTaskDetails().getTaskName()+", memberName:"+taskAssignedMembersDetails.getProjectGroupMemberDetails().getUserSignUpDetails().getUserEmail()+", updatedDate:"+updatedDate+"description:"+ description+", donePercentage:"+donePercentage+", completedDate:"+completedDate+"}";
	}
	
	
	public static class TaskStatusDetailsId implements Serializable {
	
	/**
		 * 
		 */
		private static final long serialVersionUID = -1585674114949416651L;
	private Long id;
	
		
	}
}
