package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.repository.CrudRepository;

import ca.timisencotech.projectmanagementapis.dto.StatesProvinces;


public interface StatesProvincesRepository extends CrudRepository<StatesProvinces, Long> {
	public StatesProvinces findByStateprovinceId(int stateprovinceId);
}
