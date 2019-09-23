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
import ca.timisencotech.projectmanagementapis.domain.Company;
import ca.timisencotech.projectmanagementapis.service.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest 
{
	   @Autowired
	   private MockMvc mockMvc;
		
		@Mock
		private CompanyService companyService;
		
		@InjectMocks
		private CompanyController companyController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
		}

		
		@Test
		public void testRegiterCompany() throws Exception
		{
			Company company = new  Company();
			company.setAddress("616 Armitgae Crescent");
			company.setCity("Sherwood Park");
			company.setCompanyName("Alberta");
			company.setCountry("Canada");
			company.setPhoneNumber("2059634577");
			company.setPostalCode("T8H 0T7");
			company.setRegisterBy("userAAEmail@gmail.com");
			company.setStateProvince("Edmonton");
			
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/company/registercompany")
				      .content(asJsonString(company))
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
