package ca.timisencotech.projectmanagementapis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;


public interface ProjectSupervisorsRepo extends JpaRepository<ProjectSupervisorsDetails, Long> {


	
	@Query(value ="select ps.projectid, ps.usersignupid, ps.id,ps.isactive,pt.projectname,u.email as supervisorname from projectsupervisorstable ps inner join usersignuptable u on ps.usersignupid = u.id inner join projecttable pt on ps.projectid = pt.id where pt.projectname=?1 and u.email=?2", nativeQuery = true)
	ProjectSupervisorsDetails findProjectSupervisorByProjectAndSupervisorName(String projectName,String supervisorName);
	
	
}
