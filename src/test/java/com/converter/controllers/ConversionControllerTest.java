package com.converter.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.converter.models.ConversionDataDTO;
import com.converter.services.ConverionService;
import static org.mockito.Mockito.when;

/**
 * @author shaziaadeel
 *
 */

@WebMvcTest(ConversionController.class)
class ConversionControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	@MockBean
	ConverionService conversionService;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * 
	 * @throws Exception
	 * Test case of simple loading of application
	 */
	@Test
	void loadApplicationTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/");
		 
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.view().name("conversion")).andReturn();
	
	}
	
	/**
	 * 
	 * @throws Exception
	 * Test case of simple loading of application
	 */
	@Test
	void conversionTest() throws Exception {
		
		ConversionDataDTO form = new ConversionDataDTO();
		form.addConversionData(34.5, "gallons", 236.6, "cups");
		
		//org.mockito.Mockito.when(conversionService.convertDataList(form));
		
		
		RequestBuilder request = MockMvcRequestBuilders.post("/");
		 
		MvcResult result = mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("conversion"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("form"))
				.andReturn();
	
	}

	

}
