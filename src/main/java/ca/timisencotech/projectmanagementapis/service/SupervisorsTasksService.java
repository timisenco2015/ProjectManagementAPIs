package ca.timisencotech.projectmanagementapis.service;


import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.validation.Container;


public interface SupervisorsTasksService {
	public <T> Container<T> addSupervisorTasks(SupervisorTasks supervisorTasks,BindingResult result);

}
