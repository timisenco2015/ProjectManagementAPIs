package ca.timisencotech.projectmanagementapis.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



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
import ca.timisencotech.projectmanagementapis.controller.SupervisorTasksController;
import ca.timisencotech.projectmanagementapis.domain.SupervisorTasks;
import ca.timisencotech.projectmanagementapis.service.SupervisorsTasksService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SupervisorTasksControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private SupervisorsTasksService supervisorsTasksService;
		
		@InjectMocks
		private SupervisorTasksController supervisorTasksController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(supervisorTasksController).build();
		}

		
		@Test
		public void testNewSupervisorTask() throws Exception
		{
			SupervisorTasks supervisorTasks = new  SupervisorTasks();
			supervisorTasks.setProjectName("Sherwood Project");
			supervisorTasks.setSupervisorName("userAEmail@gmail.com");
			supervisorTasks.setTaskName("Sub Task2");
			
			
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/supervisortasks/addtasktosupervisottasklist")
				      .content(asJsonString(supervisorTasks))
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
