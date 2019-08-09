package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.ProjectSupervisorsDetailsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.ProjectSupervisorsDetail;
import ca.timisencotech.projectmanagementapis.exception.ApiError;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSupervisorsDetailsDAOImpTest<T> {
	
	
	 @Autowired
	 ProjectSupervisorsDetailsDAOImp projectSupervisorsDetailDAOImp;
	 
 
		
	
	 @Test
		public void addProjectGroupTest() 
		 {
		 //checks for add new project supervisor
		 addNewProjectSupervisorServiceTest();
		 
		//checks for project and supervisor name unique test
		 addNewProjectSupervisorProjectAndSupervisorUniqueTest()  ;
		
		 //checks for project field null test
		 addNewProjectSupervisorProjectNullTest() ;
			
		 //checks for supervisor field null test
		 addNewProjectSupervisorSupervisorNullTest();
		 
		 
		 }
	 
	 
	 private void addNewProjectSupervisorServiceTest() 
	 {

	
	 ProjectSupervisorsDetail projectSupervisorsDetail = new ProjectSupervisorsDetail();
	 projectSupervisorsDetail.setIsActive(true);
	 projectSupervisorsDetail.setProjectName("Sherwood Project");
	 projectSupervisorsDetail.setSupervisorName("userEmail@gmail.com");
	 Container<T> projectSupervisorsContainer = projectSupervisorsDetailDAOImp.addProjectSupervisorsDetails(projectSupervisorsDetail);
		String typeOfObject = projectSupervisorsContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			ProjectSupervisorsDetail resultProjectSupervisorsDetail=	(ProjectSupervisorsDetail)projectSupervisorsContainer.getObject();
		assertEquals("Sherwood Project", resultProjectSupervisorsDetail.getProjectName());
		 assertEquals(true, resultProjectSupervisorsDetail.getIsActive());
		 assertEquals("userEmail@gmail.com", resultProjectSupervisorsDetail.getSupervisorName());
		
		}
		else if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)projectSupervisorsContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
			
		}
		
		
		
	 }
	 
	 
	 
	 private void addNewProjectSupervisorProjectAndSupervisorUniqueTest() 
	 {

	
	 ProjectSupervisorsDetail projectSupervisorsDetail = new ProjectSupervisorsDetail();
	 projectSupervisorsDetail.setIsActive(true);
	 projectSupervisorsDetail.setProjectName("Sherwood Project");
	 projectSupervisorsDetail.setSupervisorName("userEmail@gmail.com");
	 Container<T> projectSupervisorsContainer = projectSupervisorsDetailDAOImp.addProjectSupervisorsDetails(projectSupervisorsDetail);
		String typeOfObject = projectSupervisorsContainer.getObjectType();
		
		 if (typeOfObject.equalsIgnoreCase("Error Object"))
		{
			ApiError apiError = (ApiError)projectSupervisorsContainer.getObject();
			assertEquals("Constraint error", apiError.getMessage());
			
		}
		
		
		
	 }
	 
	 
	 private void addNewProjectSupervisorSupervisorNullTest() 
	 {

	
	 ProjectSupervisorsDetail projectSupervisorsDetail = new ProjectSupervisorsDetail();
	 projectSupervisorsDetail.setIsActive(true);
	 projectSupervisorsDetail.setProjectName("Sherwood Project");
	 projectSupervisorsDetail.setSupervisorName("userCEmail@gmail.com");
	 Container<T> projectSupervisorsContainer = projectSupervisorsDetailDAOImp.addProjectSupervisorsDetails(projectSupervisorsDetail);
		String typeOfObject = projectSupervisorsContainer.getObjectType();
		
	 if (typeOfObject.equalsIgnoreCase("Null Object"))
		{
			ApiError apiError = (ApiError)projectSupervisorsContainer.getObject();
			assertEquals("We dont have this supervisor name: userCEmail@gmail.com in our database", apiError.getMessage());
			
		}
		
		
		
	 }
	 
	 private void addNewProjectSupervisorProjectNullTest() 
	 {

	
	 ProjectSupervisorsDetail projectSupervisorsDetail = new ProjectSupervisorsDetail();
	 projectSupervisorsDetail.setIsActive(true);
	 projectSupervisorsDetail.setProjectName("SherwoodA Project");
	 projectSupervisorsDetail.setSupervisorName("userEmail@gmail.com");
	 Container<T> projectSupervisorsContainer = projectSupervisorsDetailDAOImp.addProjectSupervisorsDetails(projectSupervisorsDetail);
		String typeOfObject = projectSupervisorsContainer.getObjectType();
		
	 if (typeOfObject.equalsIgnoreCase("Null Object"))
		{
			ApiError apiError = (ApiError)projectSupervisorsContainer.getObject();
			assertEquals("We dont have this project name: SherwoodA Project in our database", apiError.getMessage());
			
		}
		
		
		
	 } 
	 
	 
	
/*
	 

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
  	 
*/
}
