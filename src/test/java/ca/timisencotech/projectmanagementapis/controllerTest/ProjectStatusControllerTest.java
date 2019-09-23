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
import ca.timisencotech.projectmanagementapis.controller.ProjectStatusController;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatus;
import ca.timisencotech.projectmanagementapis.service.ProjectStatusService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectStatusControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectStatusService projectStatusService;
		
		@InjectMocks
		private ProjectStatusController projectStatusController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectStatusController).build();
		}

		
		@Test
		public void testAddProjectStatusDetails() throws Exception
		{
			Date date= new Date();
			
			ProjectStatus projectStatus = new  ProjectStatus();
			
			Timestamp completedDate = new Timestamp(date.getTime());
			projectStatus.setCompletedDate(completedDate);
			
			projectStatus.setDescription("gfhfghgfhgfh");
			projectStatus.setDonePercentage(6.00);
			projectStatus.setProjectName("Sherwood Park Poroject");
			
			Timestamp updatedDate = new Timestamp(date.getTime());
			
			projectStatus.setUpdatedDate(updatedDate);
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectstatus/updateprojectstatus")
				      .content(asJsonString(projectStatus))
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
