package ca.timisencotech.projectmanagementapis.repository;


import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.TaskDetails;


public interface TaskRepo extends JpaRepository<TaskDetails, Long> {
	
	@Query(value ="select tt.projectid, tt.singupid,tt.id, tt.taskname,pt.projectname,tt.createddate,tt.startdate, tt.enddate, tt.description, u.email as createdby from tasktable tt inner join projecttable pt on tt.projectid=pt.id inner join usersignuptable u on tt.singupid=u.id where pt.projectname=?1 and tt.taskname=?2", nativeQuery = true)
	TaskDetails findByTaskNameAndProjectName(String projectName,String taskName);
	
	
	@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update tasktable tt inner join projecttable pt on tt.projectid=pt.id set tt.createddate=?1, tt.startdate=?2,tt.enddate=?3,tt.description=?4  where pt.projectname=?5 and tt.taskname=?6", nativeQuery = true)
	int updateTaskDetails(Timestamp createdDate,Timestamp startDate,Timestamp endDate, String description,  String projectName,String taskName);
	
}
