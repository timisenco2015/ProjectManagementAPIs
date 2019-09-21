package ca.timisencotech.projectmanagementapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.SupervisorAppraisalsDetails;

public interface SupervisorAppraisalsRepository extends JpaRepository<SupervisorAppraisalsDetails, Long> {
	
	@Query(value ="select sat.id,sat.taskassignedmembersid, sat.appraisedenddate, sat.appraisedstartdate,sat.standarda,sat.standardapoint,sat.standardb,sat.standardbpoint,\r\n" + 
			"sat.standardc,sat.standardcpoint,sat.standardd,sat.standarddpoint,sat.standarde,sat.standardepoint,sat.standardf,sat.standardfpoint,\r\n" + 
			"sat.standardg,sat.standardgpoint,sat.standardh,sat.standardgpoint,sat.standardi,sat.standardipoint,sat.standardj,sat.standardjpoint,pt.projectname,tt.taskname, ust.email as membername, u.email as supervisorname from supervisorstasktable sat\r\n" + 
			"inner join taskassignedmemberstable tamt on sat.taskassignedmembersid = tamt.id\r\n" + 
			"inner join supervisorstasktable ssts on tamt.supervisortaskid = ssts.id\r\n" + 
			"inner join tasktable tt on ssts.taskid = tt.id\r\n" + 
			"inner join usersignuptable u on ssts.usersignupid = u.id \r\n" + 
			"inner join projecttable pt on tt.projectid = pt.id\r\n" + 
			"inner join projectgroupmemberstable pgmt on tamt.projectgroupmemberid = pgmt.id\r\n" + 
			"inner join usersignuptable ust on pgmt.usersignupid = ust.id \r\n" + 
			"where pt.projectname=?1 and tt.taskname=?2 and ust.email=?3 and u.email=?4", nativeQuery = true)
	List<SupervisorAppraisalsDetails>  findSupervisorAppraisalsDetails(String projectName,String taskName,String memberName,String supervisorName);
	

}
