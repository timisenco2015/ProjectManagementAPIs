package ca.timisencotech.projectmanagementapis.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@IdClass(ProjectDetails.ProjectDetailsId.class)
@Table(name = "projecttable",uniqueConstraints=@UniqueConstraint(columnNames="projectname"))
public class ProjectDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1165084139687142802L;

	@Id
	@Column(name = "projectname", nullable = false,unique=true,length=40)
	private String projectName;
	
	@Column(name = "createddate", nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "startdate", nullable = false)
	private Timestamp startDate;
	
	@Column(name = "enddate", nullable = false)
	private Timestamp endDate;
	
	
	
	@Column(name = "description",columnDefinition = "TEXT")
	private String description;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "createdby",referencedColumnName="email" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserSignUpDetails userSignUpDetails;
	
	
	@Bean
	public String getProjectName() {
		return projectName;
	}

	
	@Bean
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
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
	public UserSignUpDetails getUserSignUpDetails() {
		return userSignUpDetails;
	}

	
	@Bean
	public void setUserSignUpDetails(UserSignUpDetails userSignUpDetails) {
		this.userSignUpDetails = userSignUpDetails;
	}


	public String toString()
	{
		return "{ projectName:"+projectName+", createdDate:"+createdDate+", startDate:"+startDate+", endDate:"+
				", endDate:"+endDate+", description:"+description+", createdBy:"+userSignUpDetails.getUserEmail();
	}

	public static class ProjectDetailsId implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -1165084139687142802L;

		private String projectName;
		
		
	}

}
