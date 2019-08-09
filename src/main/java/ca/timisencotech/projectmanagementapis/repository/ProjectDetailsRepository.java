package ca.timisencotech.projectmanagementapis.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;



public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {
	
	ProjectDetails findProjectDetailsByProjectName (String projectName);
	
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query(value ="update projecttable p set p.createddate=?1, p.startdate=?2,p.enddate=?3,p.description=?4,p.createdby=?5  where p.projectname=?1", nativeQuery = true)
	int updateProjectDetails(Timestamp createdDate,Timestamp startDate,Timestamp endDate, String description, String createdBy, String projectName);
	

}
