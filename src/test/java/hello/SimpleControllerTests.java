package hello;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.net.HttpCookie;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
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
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springstudy.domain.Country;
import com.springstudy.service.DemoService;
import com.springstudy.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml","classpath:/configs/applicationContext.xml" })

@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SimpleControllerTests {
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	DemoService demoService;
	@Autowired
	TestService testService;

	private MockMvc mockMvc;
	private MockHttpSession session;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
		this.session = new MockHttpSession();
	}

	@Test
	public void getTestMsg() throws Exception {
		this.mockMvc.perform((get("/hello")).accept(MediaType.ALL)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void insert() {
		List<Country> list = testService.list();		
		System.out.println("------list----->"+list);
		/*Country country = new Country();
		country.setAbbr("2222");
		country.setName("adfdfd");
		demoService.save(country);*/
		HttpSession session=null;  
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession contextSess = attr == null ? session : attr.getRequest().getSession(true);
		
		Cookie[] cookie = null;
		Cookie[] contextCookie = attr == null ? cookie : attr.getRequest().getCookies();
		Assert.notNull(list, "cookie[] is null");		 
	}
}