package ca.timisencotech.projectmanagementapis.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ca.timisencotech.projectmanagementapis.dto.ProjectStatusDetails;


public interface ProjectStatusRepo extends JpaRepository<ProjectStatusDetails, Long> {

	@Query(value ="select pst.supervisorid,pst.id, pst.updateddate,pst.description,pst.donePercentage,pst.completedDate,pt.projectname, u.email as supervisorname from projectstatustable pst"
			+ " inner join projectsupervisorstable ps on pst.supervisorid = ps.id  "
			+ "inner join usersignuptable u on u.id = ps.usersignupid "
			+ "inner join projecttable pt on ps.projectid=pt.id "
			+ "where pt.projectname=?1 and u.email=?2", nativeQuery = true)
	List<ProjectStatusDetails> findProjectStatusDetails(String projectName,String supervisorName);
	
}
