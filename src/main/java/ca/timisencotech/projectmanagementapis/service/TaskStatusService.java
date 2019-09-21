package ca.timisencotech.projectmanagementapis.service;

import org.springframework.validation.BindingResult;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskStatusService {
	public <T> Container<T> addTaskStatusDetails(TaskStatus taskStatus,BindingResult result);
	}
