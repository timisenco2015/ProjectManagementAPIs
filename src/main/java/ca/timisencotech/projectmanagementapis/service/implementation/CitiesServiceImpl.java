package ca.timisencotech.projectmanagementapis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.Application;
import ca.timisencotech.projectmanagementapis.dao.implementation.CityDAOImp;
import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.service.CitiesService;
import ca.timisencotech.projectmanagementapis.validation.Container;




@Service("CitiesService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class CitiesServiceImpl implements CitiesService{
	
	
	@Autowired
	private CityDAOImp cityDAOImp;
	
	
	@Override
	public <T> Container<T> addCity(City city,BindingResult result) {
		
		Application.getLogger().info("addCity method in Cities Service.");
	    
		return cityDAOImp.addCity(city);
	}

}
