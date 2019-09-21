package ca.timisencotech.projectmanagementapis.service;
import org.springframework.validation.BindingResult;

import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupMemberService {
	public <T> Container<T> addMemberToProjectGroup(ProjectGroupMembers projectGroupMembers,BindingResult result);
	public <T> Container<T> changeProjectMemberGroup(ProjectGroupMembers projectGroupMembers,BindingResult result);
	public <T> Container<T> removeMemberFromProjectGroup(ProjectGroupMembers projectGroupMembers,BindingResult result);

}
