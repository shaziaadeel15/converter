package com.converter.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author shaziaadeel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileServiceTest {

	@Autowired
	FileService fileService;
	
	/**
	 * Successful test case
	 */
	@Test
	void readFileSuccessTestCase() {
		
		try {
			
			assertNotNull(fileService.readDataFromFile(getInputCorrectFile()));
			
		} catch (FileUploadException|IOException e) {
			fail("read file test case fail with exception"+e.getMessage());
		} 
	}
	

	/**
	 * Fail test case, input file object is null
	 */
	@Test
	void readFileFailTestCase_1() {
		
		assertThrows( FileUploadException.class, () -> {fileService.readDataFromFile(null);}) ;
			
	}
	
	/**
	 * Fail test case, input file object do not have csv type file
	 */
	@Test
	void readFileFailTestCase_2() {
		
		assertThrows( FileUploadException.class, () -> fileService.readDataFromFile(getInputIncorrectFile())); 
	}
	
	/**
	 * Return multipart file for test
	 * @return
	 * @throws IOException
	 */
	private MultipartFile getInputCorrectFile() throws IOException
	{
		//Input File for testing data
		File inputFile = new File("input.csv");
		byte[] bytesArray = new byte[(int) inputFile.length()];

		FileInputStream fis = new FileInputStream(inputFile);
		fis.read(bytesArray); //read file into bytes[]
		fis.close();
		
		MockMultipartFile multipart = new MockMultipartFile("file", "input.csv", "text/csv", bytesArray);
		return multipart;
	}
	
	/**
	 * Return multipart file for test
	 * @return
	 * @throws IOException
	 */
	private MultipartFile getInputIncorrectFile() throws IOException
	{
		//Input File for testing data
		File inputFile = new File("pom.xml");
		byte[] bytesArray = new byte[(int) inputFile.length()];

		FileInputStream fis = new FileInputStream(inputFile);
		fis.read(bytesArray); //read file into bytes[]
		fis.close();
		
		MockMultipartFile multipart = new MockMultipartFile("file", "pom.xml", "application.xml", bytesArray);
		return multipart;
	}

}
