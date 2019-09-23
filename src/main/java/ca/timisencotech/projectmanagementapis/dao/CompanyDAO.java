package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CompanyDAO {
	public <T> Container<T> addCompany(Company company);
}
