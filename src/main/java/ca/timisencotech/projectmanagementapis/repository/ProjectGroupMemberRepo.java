package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupMemberDetails;




public interface ProjectGroupMemberRepo extends JpaRepository<ProjectGroupMemberDetails, Long> {
	

	@Query(value ="select pgm.id,pgm.usersignupid,pgm.projectgroupid, pgm.isactive,pt.projectname,pg.groupname,pgm.activitiesupdate,u.email as membername from projectgroupmemberstable pgm "
			+ "inner join projectgrouptable pg on pgm.projectgroupid = pg.id "
			+ "inner join projectsupervisorstable pst on pg.supervisorid=pst.id "
			+ "inner join projecttable pt on pst.projectid=pt.id"
			+ " inner join usersignuptable u on u.id=pgm.usersignupid where pt.projectname=?1 and u.email=?2", nativeQuery = true)
	ProjectGroupMemberDetails findProjectMemberByProjectname(String projectName,String memberName);
	
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update projectgroupmembertable pgm inner join usersignuptable u on u.id=pgm.usersignupid inner join  set pgm.projectgroupid=?1 where pgm.usersignupid=?2", nativeQuery = true)
	int updateProjectMemberGroup(String groupName, String projectName,String memberName);
	
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update projectgroupmembertable pgm set pgm.isactive=?1 where pgm.projectgroupid=?2 and pgm.usersignupid=?3", nativeQuery = true)
	int deleteProjectGroupMember(boolean isActive,String projectName,String  memberName);
	

	

}
