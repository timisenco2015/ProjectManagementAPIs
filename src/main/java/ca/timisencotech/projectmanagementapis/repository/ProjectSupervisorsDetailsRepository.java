package ca.timisencotech.projectmanagementapis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.ProjectSupervisorsDetails;


public interface ProjectSupervisorsDetailsRepository extends JpaRepository<ProjectSupervisorsDetails, Long> {


	
	@Query(value ="select isactive,projectname,supervisorname from projectsupervisorstable where projectname=?1 and supervisorname=?2", nativeQuery = true)
	ProjectSupervisorsDetails findProjectSupervisorByProjectAndSupervisorName(String projectname,String supervisorname);
	
	
}
