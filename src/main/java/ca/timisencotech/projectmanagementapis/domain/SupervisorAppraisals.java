package ca.timisencotech.projectmanagementapis.domain;

import java.io.Serializable;
import java.sql.Timestamp;



public class SupervisorAppraisals implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = -5156651081795722632L;

	

	private String standardA;
	private int standardAPoint;
	private String standardB;
	private int standardBPoint;
	private String standardC;
	private int standardCPoint;
	private String standardD;
	private int standardDPoint;
	private String standardE;
	private int standardEPoint;
	private String standardF;
	private int standardFPoint;
	private String standardG;
	private int standardGPoint;
	private String standardH;
	private int standardHPoint;
	private String standardI;
	private int standardIPoint;
	private String standardJ;
	private int standardJPoint;
	private Timestamp appraisedStartDate;
	private Timestamp appraisedEndDate;
	private String supervisorName;
	private String subordinateMember;
	private String projectName;
	private String taskName;
	private String description;

	
	
	public  SupervisorAppraisals()
	{
		
	}
	
	
	
	
	
	
	
	
	
	public String getStandardA() {
		return standardA;
	}









	public void setStandardA(String standardA) {
		this.standardA = standardA;
	}









	public int getStandardAPoint() {
		return standardAPoint;
	}









	public void setStandardAPoint(int standardAPoint) {
		this.standardAPoint = standardAPoint;
	}









	public String getStandardB() {
		return standardB;
	}









	public void setStandardB(String standardB) {
		this.standardB = standardB;
	}









	public int getStandardBPoint() {
		return standardBPoint;
	}









	public void setStandardBPoint(int standardBPoint) {
		this.standardBPoint = standardBPoint;
	}









	public String getStandardC() {
		return standardC;
	}









	public void setStandardC(String standardC) {
		this.standardC = standardC;
	}









	public int getStandardCPoint() {
		return standardCPoint;
	}









	public void setStandardCPoint(int standardCPoint) {
		this.standardCPoint = standardCPoint;
	}









	public String getStandardD() {
		return standardD;
	}









	public void setStandardD(String standardD) {
		this.standardD = standardD;
	}









	public int getStandardDPoint() {
		return standardDPoint;
	}









	public void setStandardDPoint(int standardDPoint) {
		this.standardDPoint = standardDPoint;
	}









	public String getStandardE() {
		return standardE;
	}









	public void setStandardE(String standardE) {
		this.standardE = standardE;
	}









	public int getStandardEPoint() {
		return standardEPoint;
	}









	public void setStandardEPoint(int standardEPoint) {
		this.standardEPoint = standardEPoint;
	}









	public String getStandardF() {
		return standardF;
	}









	public void setStandardF(String standardF) {
		this.standardF = standardF;
	}









	public int getStandardFPoint() {
		return standardFPoint;
	}









	public void setStandardFPoint(int standardFPoint) {
		this.standardFPoint = standardFPoint;
	}









	public String getStandardG() {
		return standardG;
	}









	public void setStandardG(String standardG) {
		this.standardG = standardG;
	}









	public int getStandardGPoint() {
		return standardGPoint;
	}









	public void setStandardGPoint(int standardGPoint) {
		this.standardGPoint = standardGPoint;
	}









	public String getStandardH() {
		return standardH;
	}









	public void setStandardH(String standardH) {
		this.standardH = standardH;
	}









	public int getStandardHPoint() {
		return standardHPoint;
	}









	public void setStandardHPoint(int standardHPoint) {
		this.standardHPoint = standardHPoint;
	}









	public String getStandardI() {
		return standardI;
	}









	public void setStandardI(String standardI) {
		this.standardI = standardI;
	}









	public int getStandardIPoint() {
		return standardIPoint;
	}









	public void setStandardIPoint(int standardIPoint) {
		this.standardIPoint = standardIPoint;
	}









	public String getStandardJ() {
		return standardJ;
	}









	public void setStandardJ(String standardJ) {
		this.standardJ = standardJ;
	}









	public int getStandardJPoint() {
		return standardJPoint;
	}









	public void setStandardJPoint(int standardJPoint) {
		this.standardJPoint = standardJPoint;
	}









	public Timestamp getAppraisedStartDate() {
		return appraisedStartDate;
	}









	public void setAppraisedStartDate(Timestamp appraisedStartDate) {
		this.appraisedStartDate = appraisedStartDate;
	}









	public Timestamp getAppraisedEndDate() {
		return appraisedEndDate;
	}









	public void setAppraisedEndDate(Timestamp appraisedEndDate) {
		this.appraisedEndDate = appraisedEndDate;
	}









	public String getSupervisorName() {
		return supervisorName;
	}









	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}









	public String getSubordinateMember() {
		return subordinateMember;
	}









	public void setSubordinateMember(String subordinateMember) {
		this.subordinateMember = subordinateMember;
	}









	public String getProjectName() {
		return projectName;
	}









	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}









	public String getTaskName() {
		return taskName;
	}









	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	

	public String getDescription() {
		return description;
	}


	
	public void setDescription(String description) {
		this.description = description;
	}









	@Override
	public String toString()
	{
		return "{ standardA:"+standardA+", standardAPoint:"+standardAPoint
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
				+", subordinateMember:"+subordinateMember+", projectName:"+ projectName+
				", supervisorName:"+supervisorName+
				", taskName:"+taskName+"}";
			
	}
	
	
	
}
