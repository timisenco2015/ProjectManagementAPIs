package ca.timisencotech.projectmanagementapis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;


public interface ProjectStatusDetailsRepository extends JpaRepository<ProjectStatusDetails, Long> {

	
}
