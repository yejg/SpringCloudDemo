package com.ye.app;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ye.app.action.ConfigProp;
import com.ye.app.action.TestController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConfigClientApp.class)
public class TestHttp {
	private MockMvc mvc;
	
	@Autowired
	private TestController testController;
	
	@Autowired
	private ConfigProp prop;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(testController).build();
	}

	@Test
	public void getHello() throws Exception {
		System.out.println(prop.getKey1());
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/from");
		builder.accept(MediaType.APPLICATION_JSON);
		ResultActions ra = mvc.perform(builder);
		ra.andExpect(status().isOk());
		
		MvcResult mvcResult = ra.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
}
