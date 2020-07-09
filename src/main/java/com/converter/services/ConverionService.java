package com.converter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.models.ConversionData;
import com.converter.models.ConversionDataDTO;
import com.converter.services.utilities.UnitConversionService;

/**
 * 
 * @author shaziaadeel
 * Service class for doing unit conversion on input data
 */
@Service
public class ConverionService {
	
	Logger logger = LoggerFactory.getLogger(ConverionService.class);
	
	final String CORRECT_RESULT = "Correct";
	final String INCORRECT_RESULT = "Incorrect";
	final String INVALID_RESULT = "Invalid";
	
	@Autowired
	UnitConversionService unitConversionService ;
	
	public ConverionService() {
		super();
	}

	/**
	 * 
	 * @param data
	 * @return Return string of type 
	 * 			Correct: When conversion is done correctly
	 *          Incorrect: When conversion is not done correctly
	 *          Invalid: Input data is invalid
	 */
	public String convert(ConversionData data) 
	{
		
		try {
			Double actualResultDouble = unitConversionService.convert(data.getInputUnitString(),  data.getInputDouble(), data.getOutputUnitString());
			logger.trace("ConverionService...actual value from user = "+actualResultDouble);
			
			Double resDouble =  Math.round(data.getResponseDouble() * 10D) / 10D;
			logger.trace("ConverionService...after rounding  = "+resDouble);
			
			///Check calculated value equal to target value, iff there is different of 0.1 then ignore it
			if( Math.abs(actualResultDouble.doubleValue() - resDouble.doubleValue() ) < 0.2){
				return CORRECT_RESULT;
			}
			else {
				return INCORRECT_RESULT;
			}
		}
		catch (IllegalArgumentException e) {
			return INVALID_RESULT;
		}	
	}
	
	/**
	 * 
	 * @param datalist
	 * 
	 *  Function to convert whole list of data
	 */
	public void convertDataList(ConversionDataDTO datalist) 
	{
		for(ConversionData data: datalist.getConversionDatas())
		{
			data.setResultString(convert(data));
		}
	}
	

}
