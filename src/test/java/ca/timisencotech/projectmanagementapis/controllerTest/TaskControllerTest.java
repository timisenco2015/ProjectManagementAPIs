package ca.timisencotech.projectmanagementapis.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.timisencotech.projectmanagementapis.controller.TaskController;
import ca.timisencotech.projectmanagementapis.domain.Task;
import ca.timisencotech.projectmanagementapis.service.TaskService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private TaskService taskService;
		
		@InjectMocks
		private TaskController taskController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
		}

		
		@Test
		public void testAddNewUserLoginDetails() throws Exception
		{
			Date date= new Date();
			
			Task task = new Task();
			
			
			task.setCreatedBy("userEmail@gmail.com");
			
			Timestamp createdDate = new Timestamp(date.getTime());
			task.setCreatedDate(createdDate);
			
			task.setDescription("fbdfbdfbdfb");
			
			Timestamp endDate = new Timestamp(date.getTime());
			task.setEndDate(endDate);
			
			task.setProjectName("Brandon Project");
			
			Timestamp startDate = new Timestamp(date.getTime());
			task.setStartDate(startDate);
			
			task.setTaskName("Sub Task1");
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/createNewTask")
				      .content(asJsonString(task))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
				     
		
		}
		
		
		
		
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		

}
