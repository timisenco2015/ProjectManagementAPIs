package ca.timisencotech.projectmanagementapis.service;


import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface StatesProvincesService {
	public <T> Container<T> addStateProvince(StateProvince stateProvince,BindingResult result);

}
