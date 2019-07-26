package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface CitiesService {
	public <T> Container<T> addCity(City city,BindingResult result);
}
