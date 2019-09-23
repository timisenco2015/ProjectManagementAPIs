package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsPrivilegesDetails;

public interface SupervisorsPrivilegesRepo extends JpaRepository<SupervisorsPrivilegesDetails, Long> {
	
	

}
