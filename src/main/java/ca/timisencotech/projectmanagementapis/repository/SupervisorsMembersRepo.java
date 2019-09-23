package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsMembersDetails;

public interface SupervisorsMembersRepo extends JpaRepository<SupervisorsMembersDetails, Long> {
	
	
	@Query(value ="select smt.id,smt.supervisorid,smt.projectgroupmemberid, ptt.projectName,u1.email as supervisorName,u2.email as memberName from supervisorsmemberstable smt\r\n" + 
			"	inner join projectsupervisorstable pst on smt.supervisorid = pst.id\r\n" + 
			"	inner join usersignuptable u1 on pst.usersignupid = u1.id\r\n" + 
			"	inner join projecttable ptt on pst.projectid=ptt.id\r\n" + 
			"	inner join projectgroupmemberstable pgt on smt.projectgroupmemberid=pgt.id\r\n" + 
			"	inner join usersignuptable u2 on pgt.usersignupid = u2.id where ptt.projectname=?1 and u1.email=?2 and u2.email =?3", nativeQuery = true)
	SupervisorsMembersDetails findSupervisorsMembersDetails(String projectName,String supervisorName,String memberName);
	
}
