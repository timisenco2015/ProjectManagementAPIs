package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface StatesProvincesDAO {
	public <T> Container<T> addStatesProvinces(StateProvince stateProvince);

}
