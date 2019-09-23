package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroup;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepo;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectGroupDAOImp projectGroupDAOImp;
	 
	 @Autowired
	 ProjectSupervisorsRepo projectSupervisorsRepo;
 
		

	 
	 @Test
	 public void addNewProjectGroupTest() 
	 {

	
	 Date date= new Date();
		
	 ProjectGroup projectGroup = new ProjectGroup();
	 
	 projectGroup.setGroupName("group1");
	 Timestamp createdDate = new Timestamp(date.getTime());	
	 projectGroup.setCreatedDate(createdDate);
	 projectGroup.setDescription("ddfdfdfdf");
	 projectGroup.setIsActive(true);
	 projectGroup.setProjectName("Sherwood Project");
	 projectGroup.setCreatedBy("userAEmail@gmail.com");
	
		 Container<T> projectGroupContainer = projectGroupDAOImp.addProjectGroup(projectGroup);
		String typeOfObject =  projectGroupContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectGroup resultProjectGroup=	(ProjectGroup)projectGroupContainer.getObject();
		assertTrue(resultProjectGroup.getIsActive());
		 assertEquals("userAEmail@gmail.com", resultProjectGroup.getCreatedBy());
		 assertEquals(createdDate, resultProjectGroup.getCreatedDate());
		 assertEquals("ddfdfdfdf", resultProjectGroup.getDescription());
		 assertEquals("group1", resultProjectGroup.getGroupName());
		assertEquals("Sherwood Project", resultProjectGroup.getProjectName());
	
		
		date= new Date();
			
		 projectGroup = new ProjectGroup();
		 
		 projectGroup.setGroupName("group4");
		 createdDate = new Timestamp(date.getTime());	
		 projectGroup.setCreatedDate(createdDate);
		 projectGroup.setDescription("ddfdfdfdf");
		 projectGroup.setIsActive(true);
		 projectGroup.setProjectName("Winnipeg Project");
		 projectGroup.setCreatedBy("userACAFEmail@gmail.com");
		
		 projectGroupContainer = projectGroupDAOImp.addProjectGroup(projectGroup);
		typeOfObject =  projectGroupContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
			resultProjectGroup=	(ProjectGroup)projectGroupContainer.getObject();
			assertTrue(resultProjectGroup.getIsActive());
			 assertEquals("userACAFEmail@gmail.com", resultProjectGroup.getCreatedBy());
			 assertEquals(createdDate, resultProjectGroup.getCreatedDate());
			 assertEquals("ddfdfdfdf", resultProjectGroup.getDescription());
			 assertEquals("group4", resultProjectGroup.getGroupName());
			assertEquals("Winnipeg Project", resultProjectGroup.getProjectName());
			}
		
	
	// checks for unique constraint	
					
		date= new Date();
			
		 
		projectGroup = new ProjectGroup();
		 projectGroup.setGroupName("group1");
		 createdDate = new Timestamp(date.getTime());	
		 projectGroup.setCreatedDate(createdDate);
		 projectGroup.setDescription("ddfdfdfdf");
		 projectGroup.setIsActive(true);
		 projectGroup.setProjectName("Sherwood Project");
		 projectGroup.setCreatedBy("userAEmail@gmail.com");
		
		 projectGroupContainer = projectGroupDAOImp.addProjectGroup(projectGroup);
		typeOfObject =  projectGroupContainer.getObjectType();
		 if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)projectGroupContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
			
		
	 }
	

	 }

	
	 
	
  	 

}
