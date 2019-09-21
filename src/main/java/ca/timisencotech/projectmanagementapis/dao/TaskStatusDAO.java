package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface TaskStatusDAO {
	public <T> Container<T> addTaskStatusDetails(TaskStatus taskStatus);
	
}
