package com.converter.services.utilities;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * Test case for testing different types of unit conversion
 * @author shaziaadeel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitConversionServiceTest {

	@Autowired
	UnitConversionService UnitConversionService;
	
	/**
	 * Test case: When try to do conversion between volume and temperature unit, function should throw exception
	 */
	@Test
	void testTemperatureInvalidConversionTest1() {
		
		if(UnitConversionService==null)
			System.out.println("Object is null");
		
		assertThrows(IllegalArgumentException.class, () -> { UnitConversionService.convert("kelvin",557.0, "liter");});
		
	}
	
	/**
	 * Test case: When any invalid argument is given as unit, function should throw exception
	 */
	@Test
	void testTemperatureInvalidConversionTest2() {
		
		if(UnitConversionService==null)
			System.out.println("Object is null");
		
		assertThrows(IllegalArgumentException.class, () -> { UnitConversionService.convert("sun",557.0, "liter");});
		
	}
	
	/**
	 * Test case: When input unit is of type volume and input value is less than 0
	 */
	@Test
	void testTemperatureInvalidConversionTest3() {
		
		if(UnitConversionService==null)
			System.out.println("Object is null");
		
		assertThrows(IllegalArgumentException.class, () -> { UnitConversionService.convert("liter",-1.0, "cups");});
		
	}
	
	/**
	 *  Test Case: If source and target value is same then input value equal to output value
	 */
	@Test
	void testTemperatureFToF() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(84.2 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("fahrenheit",84.2, "fahrenheit");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: Farenheit -> Rankine Conversion
	 */
	@Test
	void testTemperatureFToR() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(543.94 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("fahrenheit",84.2, "rankine");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}

	/**
	 *  Test Case: Rankine -> Farenheit  Conversion
	 */
	@Test
	void testTemperatureRToF() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(84.2 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("rankine",543.9, "fahrenheit");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: Farenheit -> Celcius Conversion
	 */
	@Test
	void testTemperatureFToC() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(284.4 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("fahrenheit",543.9, "celcius");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	
	/**
	 *  Test Case:  Celcius -> Farenheit  Conversion
	 */
	@Test
	void testTemperatureCToF() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(543.9 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("celcius",284.4, "fahrenheit");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	
	/**
	 *  Test Case:  Farenheit -> Kelvin  Conversion
	 */
	@Test
	void testTemperatureFToK() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(557.0 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("fahrenheit",542.9, "kelvin");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	
	/**
	 *  Test Case:  Kelvin -> Farenheit  Conversion
	 */
	@Test
	void testTemperatureKToF() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(542.9 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("kelvin",557.0, "fahrenheit");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: Cup -> Liter
	 */
	@Test
	void testTemperatureCupToLiter() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(6.1 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("cups",25.6, "liters");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: Liter -> Cup
	 */
	void testTemperatureLiterToCup() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(25.6 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("liters",6.1, "cups");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: TableSpoon -> Liter
	 */
	@Test
	void testTemperatureTablesSpoonToLiter() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(14.8 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("Tablespoons",1000.0, "liters");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: cubic inches -> Liter
	 */
	@Test
	void testTemperatureCubicInchesToLiter() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(16.4 * 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("cubic-inches",1000.0, "liters");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: cubic feet -> Liter
	 */
	@Test
	void testTemperatureCubicFeetToGallon() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(74.8* 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("cubic-feet",10.0, "gallon");
	
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
	
	/**
	 *  Test Case: gallon -> Liter
	 */
	@Test
	void testTemperatureGallonToLiter() {
		if(UnitConversionService==null)
			System.out.println("Object is null");
		Double correctDouble = Math.round(0.0* 10D) / 10D;
		Double resultDouble = UnitConversionService.convert("gallon",0.0, "liter");
	   
		assertEquals(correctDouble, resultDouble, "Conversion fail");
	}
}
