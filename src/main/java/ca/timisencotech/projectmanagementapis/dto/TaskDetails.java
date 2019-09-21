package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
@IdClass(TaskDetails.TaskDetailsId.class)
@Table(name = "tasktable",uniqueConstraints=@UniqueConstraint(columnNames={"projectid","taskname"}))
public class TaskDetails implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -4494162419880180365L;




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	

	
	@Column(name = "taskname",length=40, nullable = false)
	private String taskName;
	
	
	@Column(name = "createddate",length=20,nullable = false)
	private Timestamp createdDate;

	
	@Column(name = "startdate", length=20)
	private Timestamp startDate;
	
	@Column(name = "enddate", length=20)
	private Timestamp endDate;
	
	
	@Column(name = "description",columnDefinition="LONGTEXT",nullable = false)
	private String description;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "projectid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProjectDetails projectDetails;
	


	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "singupid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;

	
	@OneToMany(mappedBy= "taskDetails", cascade = CascadeType.ALL)
	private List<SupervisorTasksDetails> supervisorTasksDetails = 	new ArrayList<SupervisorTasksDetails>();


	
	@Bean
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	

	@Bean
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	

	@Bean
	public Timestamp getStartDate() {
		return startDate;
	}

	@Bean
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Bean
	public Timestamp getEndDate() {
		return endDate;
	}

	@Bean
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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
	public String getTaskName() {
		return taskName;
	}

	@Bean
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	public List<SupervisorTasksDetails> getSupervisorTasksDetails() {
		return supervisorTasksDetails;
	}

	@Bean
	public void setSupervisorTasksDetails(List<SupervisorTasksDetails> supervisorTasksDetails) {
		this.supervisorTasksDetails = supervisorTasksDetails;
	}

/*
	@Override
	public String toString()
	{
		return "{ projectName:"+projectDetails.getProjectName()+", taskName:"+taskName+", createdDate:"+createdDate+", startDate:"+startDate+", endDate:"+
				", endDate:"+endDate+", description:"+description+", createdBy:"+userSignUpDetails.getUserEmail()+", createdBy:"+userSignUpDetails.getUserEmail()+"}";
	}
*/
	public static class TaskDetailsId implements Serializable {
	  
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 5542547965776869290L;
		private Long id;
		
	}

}
