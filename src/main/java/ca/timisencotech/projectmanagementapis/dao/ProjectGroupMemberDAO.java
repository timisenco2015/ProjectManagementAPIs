package ca.timisencotech.projectmanagementapis.dao;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.validation.Container;

public interface ProjectGroupMemberDAO {
	public <T> Container<T> addMemberToProjectGroup(ProjectGroupMembers projectGroupMembers);
	public <T> Container<T> changeProjectMemberGroup(ProjectGroupMembers projectGroupMembers);
	public <T> Container<T> removeMemberFromProjectGroup(ProjectGroupMembers projectGroupMembers);
}
