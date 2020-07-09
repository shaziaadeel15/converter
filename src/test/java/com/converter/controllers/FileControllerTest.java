package com.converter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.converter.models.ConversionDataDTO;
import com.converter.models.FileData;
import com.converter.services.FileService;

/**
 * 
 * @author shaziaadeel
 * FileController test cases
 */
@WebMvcTest(FileController.class)
class FileControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	@MockBean
	private FileService fileService;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	 }

	/**
	 * 
	 * @throws Exception
	 * Test case of successful file uploading
	 */
	@Test
	void fileUploadSuccessTest() throws Exception 
	{
		//Input File for testing data
		File inputFile = new File("input.csv");
		byte[] bytesArray = new byte[(int) inputFile.length()];

		FileInputStream fis = new FileInputStream(inputFile);
		fis.read(bytesArray); //read file into bytes[]
		fis.close();
		
		MockMultipartFile multipart = new MockMultipartFile("file", "input.csv", "text/csv", bytesArray);
		
		FileData fileData = new FileData();
		fileData.setMultipartFile(multipart);
		fileData.setFileTypeString("csv");
		
		ConversionDataDTO dataList = new ConversionDataDTO();
		dataList.addConversionData("34.5", "gallons", "236.6", "cups");
		
		//mocking service function
		when(fileService.readDataFromFile(fileData.getMultipartFile())).thenReturn(dataList);
		
		///generate post request
		RequestBuilder request = MockMvcRequestBuilders.post("/fileupload").flashAttr("fileData", fileData);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("form")).andReturn();
	}

	/**
	 * 
	 * @throws Exception
	 * Test case when file uploading fails
	 */
	@Test
	void fileUploadFailTest1() throws Exception 
	{
		//Input File for testing data
		File inputFile = new File("input.csv");
		byte[] bytesArray = new byte[(int) inputFile.length()];

		FileInputStream fis = new FileInputStream(inputFile);
		fis.read(bytesArray); //read file into bytes[]
		fis.close();
		
		MockMultipartFile multipart = new MockMultipartFile("file", "input.csv", "text/csv", bytesArray);
		
		FileData fileData = new FileData();
		fileData.setMultipartFile(multipart);
		fileData.setFileTypeString("csv");
		
		ConversionDataDTO dataList = new ConversionDataDTO();
		dataList.addConversionData("34.5", "gallons", "236.6", "cups");
		
		//mocking service function
		when(fileService.readDataFromFile(fileData.getMultipartFile())).thenReturn(null);
		
		///generate post request
		RequestBuilder request = MockMvcRequestBuilders.post("/fileupload").flashAttr("fileData", fileData);
		
		MvcResult result = mvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.model().attributeExists("failmsg")).andReturn();
	}
	
	/**
	 * 
	 * @throws Exception
	 * Testing case when file object is not passed to post function
	 */
	@Test
	void fileUploadFailTest2() throws Exception {
		final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("err.csv");

		MockMultipartFile file =new MockMultipartFile("err.csv", "err.csv", "csv", inputStream);
		
		RequestBuilder request = MockMvcRequestBuilders.post("/fileupload", file);
		 
		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.view().name("error")).andReturn();
				
	}
}
