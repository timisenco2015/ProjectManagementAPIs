package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.City;
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface CompaniesService {
	public <T> Container<T> addCompanies(Companies companies,BindingResult result);

}
