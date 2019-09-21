package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.timisencotech.projectmanagementapis.dto.SupervisorsPrivilegesDetails;

public interface SupervisorsPrivilegesRepository extends JpaRepository<SupervisorsPrivilegesDetails, Long> {
	
	

}
