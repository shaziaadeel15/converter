package com.converter.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.converter.models.ConversionData;
import com.converter.models.ConversionDataDTO;
import com.converter.services.utilities.UnitConversionService;


/**
 * 
 * @author shaziaadeel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConversionServiceTest {

	@Autowired
	ConverionService conversionService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test Case: When conversion is done correctly in input data
	 */
	@Test
	void correctTestCase1() {
		
		ConversionData data= new ConversionData("10.0", "cubic-feet", "74.8", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.CORRECT_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}

	/**
	 * Test Case: When conversion is done correctly with error of 0.1
	 */
	@Test
	void correctTestCase2() {
		
		ConversionData data= new ConversionData("10.0", "cubic-feet", "74.7", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.CORRECT_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
	
	/**
	 * Test Case: Another scenario of correct conversion
	 */
	@Test
	void correctTestCase3() {
		
		ConversionData data= new ConversionData("10", "cubic-feet", "74.7", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.CORRECT_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
	
	/**
	 * Test Case: When conversion is done incorrectly in input data
	 */
	@Test
	void failTestCase1() {
		
		ConversionData data= new ConversionData("10.0", "cubic-feet", "73.8", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.INCORRECT_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
	
	/**
	 * Test Case: When conversion is invalid
	 */
	@Test
	void failTestCase2() {
		
		ConversionData data= new ConversionData("10.0", "abc", "73.8", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.INVALID_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
	
	/**
	 * Test Case: When input data is invalid
	 */
	@Test
	void failTestCase3() {
		
		ConversionData data= new ConversionData("abc", "liter", "73.8", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.INVALID_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
	
	/**
	 * Test Case: When response data  is invalid
	 */
	@Test
	void failTestCase4() {
		
		ConversionData data= new ConversionData("10.0", "liter", "xyz", "gallon");
		
		conversionService.convert(data);

		assertEquals(conversionService.INVALID_RESULT, conversionService.convert(data), "Conversion Service test case 1 fail");
		
	}
}
