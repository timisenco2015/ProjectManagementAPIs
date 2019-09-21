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
import ca.timisencotech.projectmanagementapis.domain.SupervisorAppraisals;
import ca.timisencotech.projectmanagementapis.exception.ErrorObject;
import ca.timisencotech.projectmanagementapis.exception.ValidationError;
import ca.timisencotech.projectmanagementapis.service.SupervisorAppraisalsService;
import ca.timisencotech.projectmanagementapis.validation.Container;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisorAppraisalsServiceImpTest<T>
{
	
	 @Autowired
	 SupervisorAppraisalsService supervisorAppraisalsService;
	

	@Test
	public void addSupervisorAppraisalsTest() throws JSONException 
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
			
			

			 DataBinder binder = new DataBinder(supervisorAppraisals);
			 Container<T> supervisorAppraisalsContainer =supervisorAppraisalsService.addSupervisorAppraisals(supervisorAppraisals,  binder.getBindingResult());
					
			String typeOfObject = supervisorAppraisalsContainer.getObjectType();
			if(typeOfObject.equalsIgnoreCase("Class Object"))
			{
			 
				SupervisorAppraisals resultSelfAppraisals=	(SupervisorAppraisals)supervisorAppraisalsContainer.getObject();
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
			 supervisorAppraisals=new SupervisorAppraisals();
				supervisorAppraisals.setStandardA("QuestionA");
				supervisorAppraisals.setStandardAPoint(4);
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
				appraisedStartDate = new Timestamp(date.getTime());
				supervisorAppraisals.setAppraisedStartDate(appraisedStartDate);
				appraisedEndDate = new Timestamp(date.getTime());
				supervisorAppraisals.setAppraisedEndDate(appraisedEndDate);
				
				
				 binder = new DataBinder(supervisorAppraisals);
				 supervisorAppraisalsContainer =supervisorAppraisalsService.addSupervisorAppraisals(supervisorAppraisals,  binder.getBindingResult());
						
				typeOfObject = supervisorAppraisalsContainer.getObjectType();
				if (typeOfObject.equalsIgnoreCase("Error Object"))
					{

						ErrorObject errorObject = (ErrorObject)supervisorAppraisalsContainer.getObject();
						
						 if (errorObject instanceof ValidationError)
						{
							ValidationError validationError = (ValidationError)errorObject;
							assertEquals("Failed", validationError.getMessageObject().getString("errorStatus"));
							assertEquals("Failed validation test for all or most of the fields", validationError.getMessageObject().getString("message"));
							
							
						}
					}
					
					
	 }
	
	
	 	
	 	
	 	
	
}
