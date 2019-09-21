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
@IdClass(SupervisorAppraisalsDetails.SupervisorAppraisalsDetailsId.class)
@Table(name = "supervisorappraisaltable")
public class SupervisorAppraisalsDetails implements Serializable{





	/**
	 * 
	 */
	private static final long serialVersionUID = -3104209815053145526L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "standarda",length=10, nullable=false)
	private String standardA;
	
	@Column(name = "standardapoint",length=1, nullable=false)
	private int standardAPoint;
	
	@Column(name = "standardb",length=10, nullable=false)
	private String standardB;
	
	@Column(name = "standardbpoint",length=1, nullable=false)
	private int standardBPoint;
	
	
	@Column(name = "standardc",length=10, nullable=false)
	private String standardC;
	
	@Column(name = "standardcpoint",length=1, nullable=false)
	private int standardCPoint;
	
	
	@Column(name = "standardd",length=10, nullable=false)
	private String standardD;
	
	@Column(name = "standarddpoint",length=1, nullable=false)
	private int standardDPoint;
	
	@Column(name = "standarde",length=10, nullable=false)
	private String standardE;
	
	@Column(name = "standardepoint",length=1, nullable=false)
	private int standardEPoint;
	
	@Column(name = "standardf",length=10, nullable=false)
	private String standardF;
	
	@Column(name = "standardfpoint",length=1, nullable=false)
	private int standardFPoint;
	
	@Column(name = "standardg",length=10, nullable=false)
	private String standardG;
	
	@Column(name = "standardgpoint",length=1, nullable=false)
	private int standardGPoint;
	
	
	@Column(name = "standardh",length=10, nullable=false)
	private String standardH;
	
	@Column(name = "standardhpoint",length=1, nullable=false)
	private int standardHPoint;
	
	
	@Column(name = "standardi",length=10, nullable=false)
	private String standardI;
	
	@Column(name = "standardipoint",length=1, nullable=false)
	private int standardIPoint;
	
	
	@Column(name = "standardj",length=10, nullable=false)
	private String standardJ;
	
	@Column(name = "standardjpoint",length=1, nullable=false)
	private int standardJPoint;
	
	@Column(name = "description",columnDefinition="LONGTEXT",nullable = false)
	private String description;
	
	@Column(name = "appraisedstartdate",length=15,nullable = false)
	private Timestamp appraisedStartDate;
	

	@Column(name = "appraisedenddate",length=15,nullable = false)
	private Timestamp appraisedEndDate;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supervisortasksid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	private SupervisorTasksDetails supervisorTasksDetails;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "taskassignedmembersid",referencedColumnName="id" , nullable = false,insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TaskAssignedMembersDetails taskAssignedMembersDetails;
	
	
	
	
	public  SupervisorAppraisalsDetails()
	{
		
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
	public Long getId() {
		return id;
	}

	@Bean
	public void setId(Long id) {
		this.id = id;
	}


	@Bean
	public TaskAssignedMembersDetails getTaskAssignedMembersDetails() {
		return taskAssignedMembersDetails;
	}



	@Bean
	public void setTaskAssignedMembersDetails(TaskAssignedMembersDetails taskAssignedMembersDetails) {
		this.taskAssignedMembersDetails = taskAssignedMembersDetails;
	}



	@Bean
	public String getStandardA() {
		return standardA;
	}


	@Bean
	public void setStandardA(String standardA) {
		this.standardA = standardA;
	}


	@Bean
	public int getStandardAPoint() {
		return standardAPoint;
	}


	@Bean
	public void setStandardAPoint(int standardAPoint) {
		this.standardAPoint = standardAPoint;
	}


	@Bean
	public String getStandardB() {
		return standardB;
	}


	@Bean
	public void setStandardB(String standardB) {
		this.standardB = standardB;
	}


	@Bean
	public int getStandardBPoint() {
		return standardBPoint;
	}


	@Bean
	public void setStandardBPoint(int standardBPoint) {
		this.standardBPoint = standardBPoint;
	}


	@Bean
	public String getStandardC() {
		return standardC;
	}


	@Bean
	public void setStandardC(String standardC) {
		this.standardC = standardC;
	}


	@Bean
	public int getStandardCPoint() {
		return standardCPoint;
	}


	@Bean
	public void setStandardCPoint(int standardCPoint) {
		this.standardCPoint = standardCPoint;
	}


	@Bean
	public String getStandardD() {
		return standardD;
	}


	@Bean
	public void setStandardD(String standardD) {
		this.standardD = standardD;
	}


	@Bean
	public int getStandardDPoint() {
		return standardDPoint;
	}


	@Bean
	public void setStandardDPoint(int standardDPoint) {
		this.standardDPoint = standardDPoint;
	}


	@Bean
	public String getStandardE() {
		return standardE;
	}


	@Bean
	public void setStandardE(String standardE) {
		this.standardE = standardE;
	}


	@Bean
	public int getStandardEPoint() {
		return standardEPoint;
	}


	@Bean
	public void setStandardEPoint(int standardEPoint) {
		this.standardEPoint = standardEPoint;
	}


	@Bean
	public String getStandardF() {
		return standardF;
	}


	@Bean
	public void setStandardF(String standardF) {
		this.standardF = standardF;
	}


	@Bean
	public int getStandardFPoint() {
		return standardFPoint;
	}


	@Bean
	public void setStandardFPoint(int standardFPoint) {
		this.standardFPoint = standardFPoint;
	}


	@Bean
	public String getStandardG() {
		return standardG;
	}


	@Bean
	public void setStandardG(String standardG) {
		this.standardG = standardG;
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
	public int getStandardGPoint() {
		return standardGPoint;
	}


	@Bean
	public void setStandardGPoint(int standardGPoint) {
		this.standardGPoint = standardGPoint;
	}


	@Bean
	public String getStandardH() {
		return standardH;
	}


	@Bean
	public void setStandardH(String standardH) {
		this.standardH = standardH;
	}


	@Bean
	public int getStandardHPoint() {
		return standardHPoint;
	}


	@Bean
	public void setStandardHPoint(int standardHPoint) {
		this.standardHPoint = standardHPoint;
	}


	@Bean
	public String getStandardI() {
		return standardI;
	}


	@Bean
	public void setStandardI(String standardI) {
		this.standardI = standardI;
	}


	@Bean
	public int getStandardIPoint() {
		return standardIPoint;
	}


	@Bean
	public void setStandardIPoint(int standardIPoint) {
		this.standardIPoint = standardIPoint;
	}


	@Bean
	public String getStandardJ() {
		return standardJ;
	}


	@Bean
	public void setStandardJ(String standardJ) {
		this.standardJ = standardJ;
	}


	@Bean
	public int getStandardJPoint() {
		return standardJPoint;
	}


	@Bean
	public void setStandardJPoint(int standardJPoint) {
		this.standardJPoint = standardJPoint;
	}


	@Bean
	public Timestamp getAppraisedStartDate() {
		return appraisedStartDate;
	}


	@Bean
	public void setAppraisedStartDate(Timestamp appraisedStartDate) {
		this.appraisedStartDate = appraisedStartDate;
	}


	@Bean
	public Timestamp getAppraisedEndDate() {
		return appraisedEndDate;
	}


	@Bean
	public void setAppraisedEndDate(Timestamp appraisedEndDate) {
		this.appraisedEndDate = appraisedEndDate;
	}



	









	@Override
	public String toString()
	{
		return "{supervisorname:"+supervisorTasksDetails.getProjectSupervisorsDetails().getUserSignUpDetails().getUserEmail()+", subordinateMember:"+taskAssignedMembersDetails.getProjectGroupMemberDetails().getUserSignUpDetails().getUserEmail()+", projectname:"+ taskAssignedMembersDetails.getSupervisorTasksDetails().getTaskDetails().getProjectDetails().getProjectName()+
				", taskName:"+taskAssignedMembersDetails.getSupervisorTasksDetails().getTaskDetails().getTaskName()
				+", standardA:"+standardA+", standardAPoint:"+standardAPoint
				+", standardB:"+standardB+", standardBPoint:"+standardBPoint
				+", standardC:"+standardC+", standardCPoint:"+standardCPoint
				+", standardD:"+standardD+", standardDPoint:"+standardDPoint
				+", standardE:"+standardE+", standardEPoint:"+standardEPoint
				+", standardF:"+standardF+", standardFPoint:"+standardFPoint
				+", standardG:"+standardG+", standardGPoint:"+standardGPoint
				+", standardH:"+standardH+", standardHPoint:"+standardHPoint
				+", standardI:"+standardI+", standardIPoint:"+standardIPoint
				+", standardJ:"+standardJ+", standardJPoint:"+standardJPoint
				+", appraisedStartDate:"+appraisedStartDate+", appraisedEndDate:"+appraisedEndDate
				+", appraisedStartDate:"+appraisedStartDate+", appraisedEndDate:"+appraisedEndDate
				+"}";
	}
	
	
	public static class SupervisorAppraisalsDetailsId implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -2176640554745912445L;
		private Long id;
	
		
	}
}
