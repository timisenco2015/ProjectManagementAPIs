package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectGroupDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectGroupDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectGroupDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectGroupDetailsDAOImp projectGroupDetailsDAOImp;
	 
 
		
	
	 @Test
		public void addProjectGroupTest() 
		 {
		 //checks for add new project group
		 addNewProjectGroupServiceTest();
		 
		//checks for project name field null test
		 addNewProjectGroupProjectNameNullValueConstraintTest() ;
		
		 //checks for email field null test
		 addNewProjectGroupEmailNullValueConstraintTest() ;
			
		 //checks for created field null test
		 addNewProjectGroupCreatedDateNullValueConstraintTest(); 
		 
		//checks for group and project name unique test
		 addNewProjectGroupProjectAndGroupNameUniqueConstraintTest() ;
		 
		 }
	 
	 
	 private void addNewProjectGroupServiceTest() 
	 {

	 System.out.println("--dd>");
		
	 Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 Timestamp createdDate = new Timestamp(date.getTime());
	 projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group1");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Sherwood Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectGroupDetail resultProjectGroupDetail=	(ProjectGroupDetail)projectInformationContainer.getObject();
	
		 assertEquals("checkidowu@gmail.com", resultProjectGroupDetail.getCreatedBy());
		 assertEquals(createdDate, resultProjectGroupDetail.getCreatedDate());
		 assertEquals("ddfdfdfdf", resultProjectGroupDetail.getDescription());
		 assertEquals("group1", resultProjectGroupDetail.getGroupName());
		assertEquals("Sherwood Project", resultProjectGroupDetail.getProjectName());
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
	

	 

		private void addNewProjectGroupEmailNullValueConstraintTest() 
		 {
	
		  Date date= new Date();
			
		 
		 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
		 projectGroupDetail.setCreatedBy("checkAidowu@gmail.com");
		 Timestamp createdDate = new Timestamp(date.getTime());
		 projectGroupDetail.setCreatedDate(createdDate);
		 projectGroupDetail.setDescription("ddfdfdfdf");
		 projectGroupDetail.setGroupName("group1");
		 projectGroupDetail.setIsActive(true);
		 projectGroupDetail.setProjectName("Sherwood Project");
		
	
	
			 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
			String typeOfObject = projectInformationContainer.getObjectType();
			
			if(typeOfObject.equalsIgnoreCase("Null Object"))
			{
			 
			
				ApiError apiError = (ApiError)projectInformationContainer.getObject();
				assertEquals("We dont have this user email: checkAidowu@gmail.com in our database", apiError.getMessage());
			}
			
			
			
		 }
	  
	
	 private void addNewProjectGroupProjectNameNullValueConstraintTest() 
	 {

	  Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 Timestamp createdDate = new Timestamp(date.getTime());
	 projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group1");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Ayo Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Null Object"))
		{
		 
		
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("We dont have this project name: Ayo Project in our database", apiError.getMessage());
		}
		
		
		
	 }
	 
	 private void addNewProjectGroupCreatedDateNullValueConstraintTest() 
	 {

	 // Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 //Timestamp createdDate = new Timestamp(date.getTime());
	 //projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group3");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Sherwood Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
		 
			
			
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
	 
	 
	 private void addNewProjectGroupProjectAndGroupNameUniqueConstraintTest() 
	 {

	  Date date= new Date();
		
	 
	 ProjectGroupDetail projectGroupDetail = new ProjectGroupDetail();
	 projectGroupDetail.setCreatedBy("checkidowu@gmail.com");
	 Timestamp createdDate = new Timestamp(date.getTime());
	 projectGroupDetail.setCreatedDate(createdDate);
	 projectGroupDetail.setDescription("ddfdfdfdf");
	 projectGroupDetail.setGroupName("group1");
	 projectGroupDetail.setIsActive(true);
	 projectGroupDetail.setProjectName("Sherwood Project");
	


		 Container<T> projectInformationContainer = projectGroupDetailsDAOImp.addProjectGroupDetails(projectGroupDetail);
		String typeOfObject = projectInformationContainer.getObjectType();
		if(typeOfObject.equalsIgnoreCase("Error Object"))
		{
		 
			
			
			ApiError apiError = (ApiError)projectInformationContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
		}
		
		
		
	 }
  	 

}
