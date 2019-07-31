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
import ca.timisencotech.projectmanagementapis.controller.UserLoginDetailsController;
import ca.timisencotech.projectmanagementapis.domain.UserLoginDetail;
import ca.timisencotech.projectmanagementapis.service.UserLoginDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserLoginDetailsControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private UserLoginDetailsService userLoginDetailsService;
		
		@InjectMocks
		private UserLoginDetailsController userLoginDetailsController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(userLoginDetailsController).build();
		}

		
		@Test
		public void testAddNewUserLoginDetails() throws Exception
		{
			Date date= new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			UserLoginDetail  userLoginDetail = new  UserLoginDetail();
			userLoginDetail.setUserEmail("ayobami.o.idowu@gmail.com");	
			userLoginDetail.setPassword("Test@2018");
			userLoginDetail.setLoginTime(timeStamp);
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/addUserLoginDetails")
				      .content(asJsonString(userLoginDetail))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
				     
		
		}
		
		
		@Test
		public void testConfirmUserLoginDetails() throws Exception
		{
			UserLoginDetail  userLoginDetail = new  UserLoginDetail();
			userLoginDetail.setUserEmail("userEmail@gmail.com");	
			userLoginDetail.setPassword("Test@2018");
	
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/confirmLoginDetails")
				      .content(asJsonString(userLoginDetail))
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
