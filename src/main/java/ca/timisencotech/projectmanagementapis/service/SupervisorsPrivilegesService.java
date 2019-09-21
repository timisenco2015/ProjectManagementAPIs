package ca.timisencotech.projectmanagementapis.service;


import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsPrivileges;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface SupervisorsPrivilegesService {
	public <T> Container<T> addSupervisorPrivileges(SupervisorsPrivileges supervisorsPrivileges,BindingResult result);

}
