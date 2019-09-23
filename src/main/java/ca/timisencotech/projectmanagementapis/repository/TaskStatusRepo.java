package ca.timisencotech.projectmanagementapis.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.TaskStatusDetails;


public interface TaskStatusRepo extends JpaRepository<TaskStatusDetails, Long> {

	@Query(value ="select tst.id,tst.taskassignedmembersid, tst.completeddate, tst.description, tst.donepercentage, tst.updateddate, u.email as memberName,tt.taskName,pt.projectName from taskstatustable tst" + 
			" inner join taskassignedmemberstable tamt on tst.taskassignedmembersid=tamt.id" + 
			" inner join projectgroupmemberstable pgmt on tamt.projectgroupmemberid = pgmt.id" + 
			" inner join usersignuptable u on pgmt.projectgroupid = u.id" + 
			" inner join supervisorstasktable stt on tamt.supervisortaskid = stt.id" + 
			" inner join tasktable tt on stt.taskid=tt.id" + 
			" inner join projecttable pt on tt.projectid=pt.id "
			+ "where pt.projectname=?1 and u.email=?2", nativeQuery = true)
	List<TaskStatusDetails> findTaskStatusDetails(String projectName,String memberName);
	
}
