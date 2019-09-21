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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.timisencotech.projectmanagementapis.controller.CompanyController;
import ca.timisencotech.projectmanagementapis.domain.Companies;
import ca.timisencotech.projectmanagementapis.service.CompaniesService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest 
{
	   @Autowired
	   private MockMvc mockMvc;
		
		@Mock
		private CompaniesService companiesService;
		
		@InjectMocks
		private CompanyController companyController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			Companies companies = new  Companies();
			companies.setAddress("616 Armitgae Crescent");
			companies.setCity("Sherwood Park");
			companies.setCompanyName("Alberta");
			companies.setCountry("Canada");
			companies.setPhoneNumber("2059634577");
			companies.setPostalCode("T8H 0T7");
			companies.setRegisterBy("userAAEmail@gmail.com");
			companies.setStateProvince("Edmonton");
			
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/projectmanagement/registerCompany")
				      .content(asJsonString(companies))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
						.andDo(MockMvcResultHandlers.print())
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
