package ca.timisencotech.projectmanagementapis.domainTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;




@RunWith(SpringRunner.class)
@SpringBootTest
public class SelfAppraisalsTest 
{
	@Test
	public void testSettersGetters() 
	{

		 Date date= new Date();
		 SelfAppraisals selfAppraisals=new SelfAppraisals();
			selfAppraisals.setStandardA("QuestionA");
			selfAppraisals.setStandardAPoint(4);
			selfAppraisals.setStandardB("QuestionB");
			selfAppraisals.setStandardBPoint(3);
			selfAppraisals.setStandardC("QuestionC");
			selfAppraisals.setStandardCPoint(4);
			selfAppraisals.setStandardD("QuestionD");
			selfAppraisals.setStandardDPoint(2);
			selfAppraisals.setStandardE("QuestionE");
			selfAppraisals.setStandardEPoint(3);
			selfAppraisals.setStandardF("QuestionF");
			selfAppraisals.setStandardFPoint(4);
			selfAppraisals.setStandardG("QuestionG");
			selfAppraisals.setStandardGPoint(5);
			selfAppraisals.setStandardH("QuestionH");
			selfAppraisals.setStandardHPoint(2);
			selfAppraisals.setStandardI("QuestionI");
			selfAppraisals.setStandardIPoint(1);
			selfAppraisals.setStandardJ("QuestionJ");
			selfAppraisals.setStandardJPoint(2);
			selfAppraisals.setSubordinateMember("userHEmail@gmail.com");
			selfAppraisals.setTaskName("Sub Task1");
			selfAppraisals.setProjectName("Sherwood Project");
			selfAppraisals.setDescription("fdgdjdydtf");
			Timestamp appraisedStartDate = new Timestamp(date.getTime());
			selfAppraisals.setAppraisedStartDate(appraisedStartDate);
		
			Timestamp appraisedEndDate = new Timestamp(date.getTime());
			selfAppraisals.setAppraisedEndDate(appraisedEndDate);
			
			
			
			assertEquals("QuestionA", selfAppraisals.getStandardA());
			assertEquals(4, selfAppraisals.getStandardAPoint());
			assertEquals("QuestionB",selfAppraisals.getStandardB());
			assertEquals(3, selfAppraisals.getStandardBPoint());
			assertEquals("QuestionC", selfAppraisals.getStandardC());
			assertEquals(4, selfAppraisals.getStandardCPoint());
			assertEquals("QuestionD", selfAppraisals.getStandardD());
			assertEquals(2, selfAppraisals.getStandardDPoint());
			assertEquals("QuestionE", selfAppraisals.getStandardE());
			assertEquals(3, selfAppraisals.getStandardEPoint());
			assertEquals("QuestionF", selfAppraisals.getStandardF());
			assertEquals(4, selfAppraisals.getStandardFPoint());
			assertEquals("QuestionH", selfAppraisals.getStandardH());
			assertEquals(2, selfAppraisals.getStandardHPoint());
			assertEquals("QuestionI", selfAppraisals.getStandardI());
			assertEquals(1, selfAppraisals.getStandardIPoint());
			assertEquals("QuestionJ", selfAppraisals.getStandardJ());
			assertEquals(2, selfAppraisals.getStandardJPoint());
			assertEquals("QuestionG", selfAppraisals.getStandardG());
			assertEquals(5, selfAppraisals.getStandardGPoint());
			assertEquals(appraisedEndDate, selfAppraisals.getAppraisedEndDate());
			assertEquals(appraisedStartDate, selfAppraisals.getAppraisedStartDate());
			assertEquals("userHEmail@gmail.com", selfAppraisals.getSubordinateMember());
			assertEquals("Sub Task1", selfAppraisals.getTaskName());
		
		
	}

}
