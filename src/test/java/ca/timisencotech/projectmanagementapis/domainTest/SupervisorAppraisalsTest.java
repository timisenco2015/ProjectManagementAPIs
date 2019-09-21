package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;




@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorAppraisalsTest 
{
	@Test
	public void testSettersGetters() 
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
			
			
			
			assertEquals("QuestionA", supervisorAppraisals.getStandardA());
			assertEquals(4, supervisorAppraisals.getStandardAPoint());
			assertEquals("QuestionB",supervisorAppraisals.getStandardB());
			assertEquals(3, supervisorAppraisals.getStandardBPoint());
			assertEquals("QuestionC", supervisorAppraisals.getStandardC());
			assertEquals(4, supervisorAppraisals.getStandardCPoint());
			assertEquals("QuestionD", supervisorAppraisals.getStandardD());
			assertEquals(2, supervisorAppraisals.getStandardDPoint());
			assertEquals("QuestionE", supervisorAppraisals.getStandardE());
			assertEquals(3, supervisorAppraisals.getStandardEPoint());
			assertEquals("QuestionF", supervisorAppraisals.getStandardF());
			assertEquals(4, supervisorAppraisals.getStandardFPoint());
			assertEquals("QuestionH", supervisorAppraisals.getStandardH());
			assertEquals(2, supervisorAppraisals.getStandardHPoint());
			assertEquals("QuestionI", supervisorAppraisals.getStandardI());
			assertEquals(1, supervisorAppraisals.getStandardIPoint());
			assertEquals("QuestionJ", supervisorAppraisals.getStandardJ());
			assertEquals(2, supervisorAppraisals.getStandardJPoint());
			assertEquals("QuestionG", supervisorAppraisals.getStandardG());
			assertEquals(5, supervisorAppraisals.getStandardGPoint());
			assertEquals(appraisedEndDate, supervisorAppraisals.getAppraisedEndDate());
			assertEquals(appraisedStartDate, supervisorAppraisals.getAppraisedStartDate());
			assertEquals("userAEmail@gmail.com", supervisorAppraisals.getSupervisorName());
			assertEquals("userHEmail@gmail.com", supervisorAppraisals.getSubordinateMember());
			assertEquals("Sub Task1", supervisorAppraisals.getTaskName());
		
		
	}

}
