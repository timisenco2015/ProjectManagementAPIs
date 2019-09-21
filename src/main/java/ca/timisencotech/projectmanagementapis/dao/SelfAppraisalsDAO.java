package ca.timisencotech.projectmanagementapis.dao;

import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface SelfAppraisalsDAO {
	public <T> Container<T> addSelfAppraisals(SelfAppraisals selfAppraisals);
}
