package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupMemberDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupMembers;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.repository.ProjectSupervisorsRepository;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupMemberDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectGroupMemberDAOImp projectGroupMemberDAOImp;
	 
	 @Autowired
	 ProjectSupervisorsRepository projectSupervisorsRepository;
 
		

	 
	 @Test
	 public void addNewProjectGroupServiceTest() 
	 {


	
	 ProjectGroupMembers projectGroupMembers = new ProjectGroupMembers();
	
		projectGroupMembers.setIsActive(true);
		projectGroupMembers.setGroupName("group1");
		projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
		projectGroupMembers.setMemberName("userABAEmail@gmail.com");
		projectGroupMembers.setProjectName("Winnipeg Project");
		
		
		 Container<T> projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
		String typeOfObject =  projectGroupMemberContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
		assertTrue(resultProjectGroupMember.getIsActive());
		 assertEquals("userABAEmail@gmail.com", resultProjectGroupMember.getMemberName());
		 assertEquals("group1", resultProjectGroupMember.getGroupName());
		 assertEquals("sdfsdfdsfdsfsd", resultProjectGroupMember.getActivitiesUpdate());
		 assertEquals("Winnipeg Project", resultProjectGroupMember.getProjectName());
		}
	
		
		projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group4");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userACAFEmail@gmail.com");
			projectGroupMembers.setProjectName("Winnipeg Project");
			
			projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
			typeOfObject =  projectGroupMemberContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
			assertTrue(resultProjectGroupMember.getIsActive());
			 assertEquals("userACAFEmail@gmail.com", resultProjectGroupMember.getMemberName());
			 assertEquals("group4", resultProjectGroupMember.getGroupName());
			 assertEquals("sdfsdfdsfdsfsd", resultProjectGroupMember.getActivitiesUpdate());
			 assertEquals("Winnipeg Project", resultProjectGroupMember.getProjectName());
			}
		
		
		  projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group4");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userACAGEmail@gmail.com");
			projectGroupMembers.setProjectName("Winnipeg Project");
			
			 projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
			typeOfObject =  projectGroupMemberContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
			assertTrue(resultProjectGroupMember.getIsActive());
			 assertEquals("userACAGEmail@gmail.com", resultProjectGroupMember.getMemberName());
			 assertEquals("group4", resultProjectGroupMember.getGroupName());
			 assertEquals("sdfsdfdsfdsfsd", resultProjectGroupMember.getActivitiesUpdate());
			 assertEquals("Winnipeg Project", resultProjectGroupMember.getProjectName());
			}
		
				projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group4");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userACAHEmail@gmail.com");
			projectGroupMembers.setProjectName("Winnipeg Project");
			
		 projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
			typeOfObject =  projectGroupMemberContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
			assertTrue(resultProjectGroupMember.getIsActive());
			 assertEquals("userACAHEmail@gmail.com", resultProjectGroupMember.getMemberName());
			 assertEquals("group4", resultProjectGroupMember.getGroupName());
			 assertEquals("sdfsdfdsfdsfsd", resultProjectGroupMember.getActivitiesUpdate());
			 assertEquals("Winnipeg Project", resultProjectGroupMember.getProjectName());
			}
		
			
	projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group4");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userACAIEmail@gmail.com");
			projectGroupMembers.setProjectName("Winnipeg Project");
			
			projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
			 typeOfObject =  projectGroupMemberContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				ProjectGroupMembers resultProjectGroupMember=	(ProjectGroupMembers)projectGroupMemberContainer.getObject();
			assertTrue(resultProjectGroupMember.getIsActive());
			 assertEquals("userACAIEmail@gmail.com", resultProjectGroupMember.getMemberName());
			 assertEquals("group4", resultProjectGroupMember.getGroupName());
			 assertEquals("sdfsdfdsfdsfsd", resultProjectGroupMember.getActivitiesUpdate());
			 assertEquals("Winnipeg Project", resultProjectGroupMember.getProjectName());
			}
			
		
	// checks for unique constraint	
		
		
		 projectGroupMembers = new ProjectGroupMembers();
			
			projectGroupMembers.setIsActive(true);
			projectGroupMembers.setGroupName("group1");
			projectGroupMembers.setActivitiesUpdate("sdfsdfdsfdsfsd");
			projectGroupMembers.setMemberName("userHEmail@gmail.com");
			projectGroupMembers.setProjectName("Sherwood Project");
			
			
			projectGroupMemberContainer = projectGroupMemberDAOImp.addMemberToProjectGroup(projectGroupMembers);
			typeOfObject =  projectGroupMemberContainer.getObjectType();
			if (typeOfObject.equalsIgnoreCase("Error Object"))
			{
				ApiError apiError = (ApiError)projectGroupMemberContainer.getObject();
				assertEquals("Persistence Error", apiError.getStatus());
			}
		
	 }
	

	 

	
	 
	
  	 

}
