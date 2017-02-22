package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/configs/spring-servlet.xml" })

@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SimpleControllerTests {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	private MockHttpSession session;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
		this.session = new MockHttpSession();
	}

	@Test
	public void getTestMsg() throws Exception {
		// get using get
		this.mockMvc.perform((get("/hello")).accept(MediaType.ALL)).andExpect(status().isOk()).andDo(print()); // print
	}

}