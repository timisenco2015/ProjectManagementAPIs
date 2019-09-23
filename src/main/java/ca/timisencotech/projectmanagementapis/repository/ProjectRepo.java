package ca.timisencotech.projectmanagementapis.repository;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;



public interface ProjectRepo extends JpaRepository<ProjectDetails, Long> {
	
	
	@Query(value ="select p.id,p.usersignupid,p.projectname,p.createddate,p.startdate,p.enddate,p.description,u.email as createdby from projecttable p inner join usersignuptable u on u.id= p.usersignupid where p.projectname=?1", nativeQuery = true)
	ProjectDetails findProjectDetailsByProjectName(String projectName);
	
	
	@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update projecttable p set p.createddate=?1, p.startdate=?2,p.enddate=?3,p.description=?4 where p.projectname=?5", nativeQuery = true)
	int updateProjectDetails(Timestamp createdDate,Timestamp startDate,Timestamp endDate, String description, String projectName);
	

}
