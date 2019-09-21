package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface CompaniesDAO {
	public <T> Container<T> addCompanies(Companies companies);
}
