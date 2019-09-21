package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.TaskAssignedMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskAssignedMembersService {
	public <T> Container<T> assignedTaskToMembers(TaskAssignedMembers taskAssignedMembers,BindingResult result);
	}
