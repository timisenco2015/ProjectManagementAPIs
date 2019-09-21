package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface SupervisorsPrivilegesDAO {
	public <T> Container<T> addSupervisorsPrivileges(SupervisorsPrivileges SupervisorsPrivileges);
}
