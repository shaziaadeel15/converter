/**
 * 
 */
package com.converter.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author shaziaadeel
 * ErrorController test case
 */

@WebMvcTest(ErrorController.class)
class ErrorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	void testErrorPageTest1() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders.get("/error");
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	void testErrorPageTest2() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders.get("/errorpage");
		MvcResult result = mockMvc.perform(request).andExpect(status().is4xxClientError()).andReturn();
	}
}
