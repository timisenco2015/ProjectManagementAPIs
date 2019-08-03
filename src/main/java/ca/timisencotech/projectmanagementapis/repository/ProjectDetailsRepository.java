package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.timisencotech.projectmanagementapis.dto.ProjectDetails;



public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {
	
	ProjectDetails findProjectDetailsByProjectName (String projectName);

}
