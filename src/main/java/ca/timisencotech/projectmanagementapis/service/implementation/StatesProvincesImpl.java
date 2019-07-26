package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.StatesProvincesDAOImp;
import ca.timisencotech.projectmanagementapis.domain.StateProvince;
import ca.timisencotech.projectmanagementapis.service.StatesProvincesService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@Service("StatesProvincesService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class StatesProvincesImpl implements StatesProvincesService {

	@Autowired
	private StatesProvincesDAOImp statesProvincesDAOImp;

	
	@Override
	public <T> Container<T> addStateProvince(StateProvince stateProvince,BindingResult result) {
		Application.getLogger().info("addStateProvince method in StatesProvinces Service Implementation.");
	    
		return statesProvincesDAOImp.addStatesProvinces(stateProvince);
	}

}
