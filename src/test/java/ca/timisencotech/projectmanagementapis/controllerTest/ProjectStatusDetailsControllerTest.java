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
import ca.timisencotech.projectmanagementapis.controller.ProjectStatusDetailsController;
import ca.timisencotech.projectmanagementapis.domain.ProjectStatusDetail;
import ca.timisencotech.projectmanagementapis.service.ProjectStatusDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectStatusDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectStatusDetailsService projectStatusDetailsService;
		
		@InjectMocks
		private ProjectStatusDetailsController projectStatusDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectStatusDetailsController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			Date date= new Date();
			
			ProjectStatusDetail projectStatusDetail = new  ProjectStatusDetail();
			
			Timestamp completedDate = new Timestamp(date.getTime());
			projectStatusDetail.setCompletedDate(completedDate);
			
			projectStatusDetail.setDescription("gfhfghgfhgfh");
			projectStatusDetail.setDonePercentage(6.00);
			projectStatusDetail.setProjectName("Sherwood Park Poroject");
			
			Timestamp updatedDate = new Timestamp(date.getTime());
			
			projectStatusDetail.setUpdatedDate(updatedDate);
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/newProjectSupervisor")
				      .content(asJsonString(projectStatusDetail))
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
