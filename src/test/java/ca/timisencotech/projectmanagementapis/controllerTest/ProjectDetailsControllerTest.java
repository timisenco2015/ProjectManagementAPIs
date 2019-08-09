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
import ca.timisencotech.projectmanagementapis.controller.ProjectDetailsController;
import ca.timisencotech.projectmanagementapis.domain.ProjectInformation;
import ca.timisencotech.projectmanagementapis.service.ProjectDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private ProjectDetailsService projectDetailsService;
		
		@InjectMocks
		private ProjectDetailsController projectDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(projectDetailsController).build();
		}

		
		@Test
		public void testAddNewUserLoginDetails() throws Exception
		{
			Date date= new Date();
			
			ProjectInformation projectInformation = new ProjectInformation();
			projectInformation.setCreatedBy("userEmail@gmail.com");
			
			Timestamp createdDate = new Timestamp(date.getTime());
			projectInformation.setCreatedDate(createdDate);
			projectInformation.setDescription("fbdfbdfbdfb");
			
			Timestamp endDate = new Timestamp(date.getTime());
			projectInformation.setEndDate(endDate);
			projectInformation.setProjectName("Edmonton Project");
			
			Timestamp startDate = new Timestamp(date.getTime());
			projectInformation.setStartDate(startDate);
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/addNewProjectDetails")
				      .content(asJsonString(projectInformation ))
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
