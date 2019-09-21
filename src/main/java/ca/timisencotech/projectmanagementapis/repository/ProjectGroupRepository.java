package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.ProjectGroupDetails;



public interface ProjectGroupRepository extends JpaRepository<ProjectGroupDetails, Long> {
	
	
	@Query(value ="select pgt.supervisorid,pgt.id,pgt.groupname, pgt.createddate, pgt.description, pgt.isactive,pgt.description,u.email as supervisorname from projectgrouptable pgt inner join projectsupervisorstable pst  on pgt.supervisorid = pst.id inner join projecttable pt on pst.projectid = pt.id inner join usersignuptable u on u.id= pst.usersignupid where pt.projectname=?1 and pgt.groupname=?2", nativeQuery = true)
	ProjectGroupDetails findProjectGroupDetailsByGroupName(String projectName,String groupName);
	
	
	

}
