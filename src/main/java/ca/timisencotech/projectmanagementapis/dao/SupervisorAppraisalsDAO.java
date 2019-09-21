package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface SupervisorAppraisalsDAO {
	public <T> Container<T> addSupervisorAppraisals(SupervisorAppraisals supervisorAppraisals);
}
