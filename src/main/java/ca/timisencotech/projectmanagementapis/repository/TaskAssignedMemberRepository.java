package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.TaskAssignedMembersDetails;




public interface TaskAssignedMemberRepository extends JpaRepository<TaskAssignedMembersDetails, Long> {
	
	@Query(value ="select tamt.id, tamt.supervisortaskid,tamt.projectgroupmemberid, tamt.dateassigned,tamt.description,tamt.isActive, u1.email as assignedby, u2.email as assignedTo,tt.taskname, pt.projectname from taskassignedmemberstable tamt" + 
			" inner join supervisorstasktable stt on tamt.supervisortaskid = stt.id" + 
			" inner join projectsupervisorstable pst on stt.supervisorid=pst.id" + 
			" inner join usersignuptable u1 on pst.usersignupid=u1.id" + 
			" inner join projectgroupmemberstable pgmt on tamt.projectgroupmemberid =  pgmt.id" + 
			" inner join usersignuptable u2 on pgmt.usersignupid=u2.id" + 
			" inner join  tasktable tt on stt.taskid = tt.id" + 
			" inner join projecttable pt on tt.projectid = pt.id" + 
			" where pt.projectname=?1 and u2.email=?2 and tt.taskname=?3", nativeQuery = true)
	TaskAssignedMembersDetails findTaskAssignedMember(String projectName,String memberName,String taskName);
	
	

	

}
