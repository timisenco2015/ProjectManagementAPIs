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
import ca.timisencotech.projectmanagementapis.controller.TaskStatusController;
import ca.timisencotech.projectmanagementapis.domain.TaskStatus;
import ca.timisencotech.projectmanagementapis.service.TaskStatusService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskStatusControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private TaskStatusService taskStatusService;
		
		@InjectMocks
		private TaskStatusController taskStatusController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(taskStatusController).build();
		}

		
		@Test
		public void testAddTaskStatus() throws Exception
		{
			Date date= new Date();
			
		
			
			TaskStatus  taskStatus = new  TaskStatus();
			Timestamp completedDate = new Timestamp(date.getTime());
			taskStatus.setCompletedDate(completedDate);
			taskStatus.setDescription("bdbdbbcxvb");
			taskStatus.setDonePercentage(30.34);
			taskStatus.setMemberName("userAAEmail@gmail.com");
			taskStatus.setProjectName("Brandon Project");
			taskStatus.setTaskName("Sub Task5");
			Timestamp updatedDate = new Timestamp(date.getTime());
			taskStatus.setUpdatedDate(updatedDate);
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/taskstatus/updatetaskstatus")
				      .content(asJsonString(taskStatus))
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
