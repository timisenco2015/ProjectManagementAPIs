package ca.timisencotech.projectmanagementapis.daoTest;

import static org.junit.Assert.assertEquals;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.dao.implementation.SupervisorAppraisalsDAOImp;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorAppraisalDAOImpTest<T> {
	
	
	 @Autowired
	 SupervisorAppraisalsDAOImp supervisorAppraisalsDAOImp;
	 
	
	
	
	
	
	 
	 
	 @Test
	 public void addSupervisorAppraisalServiceTest() 
	 {
		 Date date= new Date();
		 SupervisorAppraisals supervisorAppraisals=new SupervisorAppraisals();
			supervisorAppraisals.setStandardA("QuestionA");
			supervisorAppraisals.setStandardAPoint(4);
			supervisorAppraisals.setStandardB("QuestionB");
			supervisorAppraisals.setStandardBPoint(3);
			supervisorAppraisals.setStandardC("QuestionC");
			supervisorAppraisals.setStandardCPoint(4);
			supervisorAppraisals.setStandardD("QuestionD");
			supervisorAppraisals.setStandardDPoint(2);
			supervisorAppraisals.setStandardE("QuestionE");
			supervisorAppraisals.setStandardEPoint(3);
			supervisorAppraisals.setStandardF("QuestionF");
			supervisorAppraisals.setStandardFPoint(4);
			supervisorAppraisals.setStandardG("QuestionG");
			supervisorAppraisals.setStandardGPoint(5);
			supervisorAppraisals.setStandardH("QuestionH");
			supervisorAppraisals.setStandardHPoint(2);
			supervisorAppraisals.setStandardI("QuestionI");
			supervisorAppraisals.setStandardIPoint(1);
			supervisorAppraisals.setStandardJ("QuestionJ");
			supervisorAppraisals.setStandardJPoint(2);
			supervisorAppraisals.setSupervisorName("userAEmail@gmail.com");
			supervisorAppraisals.setSubordinateMember("userHEmail@gmail.com");
			supervisorAppraisals.setTaskName("Sub Task1");
			supervisorAppraisals.setProjectName("Sherwood Project");
			supervisorAppraisals.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			supervisorAppraisals.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			supervisorAppraisals.setAppraisedEndDate(appraisedEndDate);
		
		 Container<T> supervisorAppraisalsContainer =supervisorAppraisalsDAOImp.addSupervisorAppraisals(supervisorAppraisals);
		String typeOfObject = supervisorAppraisalsContainer.getObjectType();
		
		if(typeOfObject.equalsIgnoreCase("Class Object"))
		{
		 
			SupervisorAppraisals resultSupervisorAppraisals=(SupervisorAppraisals)supervisorAppraisalsContainer.getObject();
			assertEquals("QuestionA", resultSupervisorAppraisals.getStandardA());
			assertEquals(4, resultSupervisorAppraisals.getStandardAPoint());
			assertEquals("QuestionB",resultSupervisorAppraisals.getStandardB());
			assertEquals(3, resultSupervisorAppraisals.getStandardBPoint());
			assertEquals("QuestionC", resultSupervisorAppraisals.getStandardC());
			assertEquals(4, resultSupervisorAppraisals.getStandardCPoint());
			assertEquals("QuestionD", resultSupervisorAppraisals.getStandardD());
			assertEquals(2, resultSupervisorAppraisals.getStandardDPoint());
			assertEquals("QuestionE", resultSupervisorAppraisals.getStandardE());
			assertEquals(3, resultSupervisorAppraisals.getStandardEPoint());
			assertEquals("QuestionF", resultSupervisorAppraisals.getStandardF());
			assertEquals(4, resultSupervisorAppraisals.getStandardFPoint());
			assertEquals("QuestionH", resultSupervisorAppraisals.getStandardH());
			assertEquals(2, resultSupervisorAppraisals.getStandardHPoint());
			assertEquals("QuestionI", resultSupervisorAppraisals.getStandardI());
			assertEquals(1, resultSupervisorAppraisals.getStandardIPoint());
			assertEquals("QuestionJ", resultSupervisorAppraisals.getStandardJ());
			assertEquals(2, resultSupervisorAppraisals.getStandardJPoint());
			assertEquals("QuestionG", resultSupervisorAppraisals.getStandardG());
			assertEquals(5, resultSupervisorAppraisals.getStandardGPoint());
			assertEquals(appraisedEndDate, resultSupervisorAppraisals.getAppraisedEndDate());
			assertEquals(appraisedStartDate, resultSupervisorAppraisals.getAppraisedStartDate());
			assertEquals("userAEmail@gmail.com", resultSupervisorAppraisals.getSupervisorName());
			assertEquals("userHEmail@gmail.com", resultSupervisorAppraisals.getSubordinateMember());
			assertEquals("Sub Task2", resultSupervisorAppraisals.getTaskName());
			assertEquals("Sherwood Project", resultSupervisorAppraisals.getProjectName());
			assertEquals("fdgdjdydtf", resultSupervisorAppraisals.getDescription());
		}
		
		

			
			
		
	 }




	 
	 
}
