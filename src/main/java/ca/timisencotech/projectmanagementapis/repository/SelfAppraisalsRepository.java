package ca.timisencotech.projectmanagementapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.SelfAppraisalsDetails;

public interface SelfAppraisalsRepository extends JpaRepository<SelfAppraisalsDetails, Long> {
	
	
	@Query(value ="select sat.id,sat.taskassignedmembersid, sat.appraisedenddate, sat.appraisedstartdate,sat.standarda,sat.standardapoint,sat.standardb,sat.standardbpoint," + 
			"sat.standardc,sat.standardcpoint,sat.standardd,sat.standarddpoint,sat.standarde,sat.standardepoint,sat.standardf,sat.standardfpoint," + 
			"sat.standardg,sat.standardgpoint,sat.standardh,sat.standardgpoint,sat.standardi,sat.standardipoint,sat.standardj,sat.standardjpoint,"
			+ "pt.projectname,tt.taskname, ust.email as membername from selfappraisaltable sat " + 
			"inner join taskassignedmemberstable tamt on sat.taskassignedmembersid = tamt.id " + 
			"inner join supervisorstasktable ssts on tamt.supervisortaskid = ssts.id " + 
			"inner join tasktable tt on ssts.taskid = tt.id " + 
			"inner join projecttable pt on tt.projectid = pt.id " + 
			"inner join projectgroupmemberstable pgmt on tamt.projectgroupmemberid = pgmt.id " + 
			"inner join usersignuptable ust on pgmt.usersignupid = ust.id " + 
			"where pt.projectname=?1 and tt.taskname=?2 and ust.email=?3", nativeQuery = true)
	List<SelfAppraisalsDetails>  findUserAppraisalsDetails(String projectName,String taskName,String memberName);
	
}
