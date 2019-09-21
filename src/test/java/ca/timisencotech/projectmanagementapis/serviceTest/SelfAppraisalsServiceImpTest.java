package ca.timisencotech.projectmanagementapis.serviceTest;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;

import ca.timisencotech.projectmanagementapis.domain.SelfAppraisals;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SelfAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelfAppraisalsServiceImpTest<T>
{
	
	 @Autowired
	 SelfAppraisalsService selfAppraisalsService;
	

	@Test
	public void addSelfAppraisalsTest() throws JSONException 
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
		  	

			 DataBinder binder = new DataBinder(selfAppraisals);
			 Container<T> selfAppraisalsContainer = selfAppraisalsService.addSelfAppraisals(selfAppraisals, binder.getBindingResult());
					
			String typeOfObject = selfAppraisalsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				SelfAppraisals resultSelfAppraisals=	(SelfAppraisals)selfAppraisalsContainer.getObject();
				assertEquals("QuestionA", resultSelfAppraisals.getStandardA());
				assertEquals(4, resultSelfAppraisals.getStandardAPoint());
				assertEquals("QuestionB",resultSelfAppraisals.getStandardB());
				assertEquals(3, resultSelfAppraisals.getStandardBPoint());
				assertEquals("QuestionC", resultSelfAppraisals.getStandardC());
				assertEquals(4, resultSelfAppraisals.getStandardCPoint());
				assertEquals("QuestionD", resultSelfAppraisals.getStandardD());
				assertEquals(2, resultSelfAppraisals.getStandardDPoint());
				assertEquals("QuestionE", resultSelfAppraisals.getStandardE());
				assertEquals(3, resultSelfAppraisals.getStandardEPoint());
				assertEquals("QuestionF", resultSelfAppraisals.getStandardF());
				assertEquals(4, resultSelfAppraisals.getStandardFPoint());
				assertEquals("QuestionH", resultSelfAppraisals.getStandardH());
				assertEquals(2, resultSelfAppraisals.getStandardHPoint());
				assertEquals("QuestionI", resultSelfAppraisals.getStandardI());
				assertEquals(1, resultSelfAppraisals.getStandardIPoint());
				assertEquals("QuestionJ", resultSelfAppraisals.getStandardJ());
				assertEquals(2, resultSelfAppraisals.getStandardJPoint());
				assertEquals("QuestionG", resultSelfAppraisals.getStandardG());
				assertEquals(5, resultSelfAppraisals.getStandardGPoint());
				assertEquals(appraisedEndDate, resultSelfAppraisals.getAppraisedEndDate());
				assertEquals(appraisedStartDate, resultSelfAppraisals.getAppraisedStartDate());
				assertEquals("userHEmail@gmail.com", resultSelfAppraisals.getSubordinateMember());
				assertEquals("Sub Task1", resultSelfAppraisals.getTaskName());}
			
			
		
				
			// checks for validation error
				
		date= new Date();
 		selfAppraisals=new SelfAppraisals();
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
	selfAppraisals.setAppraisedStartDate(appraisedStartDate);

		binder = new DataBinder(selfAppraisals);
	 selfAppraisalsContainer = selfAppraisalsService.addSelfAppraisals(selfAppraisals, binder.getBindingResult());
			
	typeOfObject = selfAppraisalsContainer.getObjectType();
	if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)selfAppraisalsContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}
