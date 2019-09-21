package ca.timisencotech.projectmanagementapis.service;


import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface SupervisorsMembersService {
	public <T> Container<T> addSupervisorMember(SupervisorsMembers supervisorsMembers,BindingResult result);

}
