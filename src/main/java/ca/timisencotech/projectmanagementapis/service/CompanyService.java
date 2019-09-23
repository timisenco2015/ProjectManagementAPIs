package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface CompanyService {
	public <T> Container<T> addCompany(Company company,BindingResult result);

}
