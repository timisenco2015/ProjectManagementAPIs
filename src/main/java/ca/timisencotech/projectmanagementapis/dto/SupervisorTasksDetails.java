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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@IdClass(SupervisorTasksDetails.SupervisorTasksDetailsId.class)
@Table(name = "supervisorstasktable",uniqueConstraints=@UniqueConstraint(columnNames= {"supervisorid","taskid"}))

public class SupervisorTasksDetails implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = 6339421128495049137L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisorid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectSupervisorsDetails projectSupervisorsDetails;

	
	@OneToMany(mappedBy = "supervisorTasksDetails", cascade = CascadeType.ALL)
	private List<SupervisorAppraisalsDetails> supervisorAppraisalsDetails = new ArrayList<SupervisorAppraisalsDetails>();

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "taskid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TaskDetails taskDetails;
	
	
	@OneToMany(mappedBy = "supervisorTasksDetails")
	private List<TaskAssignedMembersDetails> taskAssignedMembersDetails = new ArrayList<TaskAssignedMembersDetails>();
	
	
	
	@Bean
	public List<SupervisorAppraisalsDetails> getSupervisorAppraisalsDetails() {
		return supervisorAppraisalsDetails;
	}


	@Bean
	public void setSupervisorAppraisalsDetails(List<SupervisorAppraisalsDetails> supervisorAppraisalsDetails) {
		this.supervisorAppraisalsDetails = supervisorAppraisalsDetails;
	}



	@Bean
	public ProjectSupervisorsDetails getProjectSupervisorsDetails() {
		return projectSupervisorsDetails;
	}



	@Bean
	public List<TaskAssignedMembersDetails> getTaskAssignedMembersDetails() {
		return taskAssignedMembersDetails;
	}



	@Bean
	public void setTaskAssignedMembersDetails(List<TaskAssignedMembersDetails> taskAssignedMembersDetails) {
		this.taskAssignedMembersDetails = taskAssignedMembersDetails;
	}




	@Bean
	public void setProjectSupervisorsDetails(ProjectSupervisorsDetails projectSupervisorsDetails) {
		this.projectSupervisorsDetails = projectSupervisorsDetails;
	}




	@Bean
	public TaskDetails getTaskDetails() {
		return taskDetails;
	}




	@Bean
	public void setTaskDetails(TaskDetails taskDetails) {
		this.taskDetails = taskDetails;
	}




	@Bean
	public Long getId() {
		return id;
	}


	@Bean
	public void setId(Long id) {
		this.id = id;
	}


	public  SupervisorTasksDetails()
	{
		
	}
	
	
	
	
	
	public static class SupervisorTasksDetailsId implements Serializable {
	
	/**
		 * 
		 */
		private static final long serialVersionUID = 4069738594548993141L;
	private Long id;
	
		
	}
}
