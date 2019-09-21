package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.SupervisorTasksDetails;


public interface SupervisorTasksRepository extends JpaRepository<SupervisorTasksDetails, Long> {
	
	@Query(value ="select u.email as supervisorname,pt.projectname,t.taskname,stt.supervisorid,stt.id,stt.taskid from supervisorstasktable stt \r\n" + 
			"inner join tasktable t on stt.taskid = t.id \r\n" + 
			"inner join projectsupervisorstable pst on stt.supervisorid =pst.id \r\n" + 
			"inner join usersignuptable u on pst.usersignupid = u.id \r\n" + 
			"inner join projecttable pt on t.projectid = pt.id \r\n" + 
			"where pt.projectname=?1 and u.email=?2 and t.taskname=?3", nativeQuery = true)
	SupervisorTasksDetails findSupervisorsByProjectnameAndSupervisorNameAndTaskName(String projectName, String supervisorName, String taskName);
	

}
