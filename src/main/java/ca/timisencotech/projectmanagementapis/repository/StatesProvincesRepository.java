package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;


public interface StatesProvincesRepository extends JpaRepository<StatesProvinces, Long> {
	public StatesProvinces findByStateProvinceId(int stateProvinceId);
}
