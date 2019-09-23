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
import ca.timisencotech.projectmanagementapis.controller.UserSignUpController;
import ca.timisencotech.projectmanagementapis.domain.UserSignUp;
import ca.timisencotech.projectmanagementapis.service.UserSignUpService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserSignUpControllerTest {
	 @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private UserSignUpService userSignUpService;
		
		@InjectMocks
		private UserSignUpController userSignUpController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(userSignUpController).build();
		}

		
		@Test
		public void testAddNewUserSignUp() throws Exception
		{
			
			UserSignUp  userSignUp = new  UserSignUp();
			userSignUp.setEmail("ayo.o.owu@gmail.com");	
			userSignUp.setPassword("Test@2018");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/usersignup/newusersignup")
				      .content(asJsonString(userSignUp))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
				     
		
		}
		
		
		
		@Test
		public void testUpdateUserPassword() throws Exception
		{
			UserSignUp  userSignUp = new  UserSignUp();
			userSignUp.setEmail("ayo.o.owu@gmail.com");	
			userSignUp.setPassword("Test@2018");
	
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/usersignup/changePassword")
				      .content(asJsonString(userSignUp))
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
