package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface SupervisorTasksDAO {
	public <T> Container<T> addSupervisorTask(SupervisorTasks supervisorTasks);
	
}
