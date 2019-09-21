package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.SupervisorsMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface SupervisorsMembersDAO {
	public <T> Container<T> addSupervisorMember(SupervisorsMembers supervisorsMembers);
}
