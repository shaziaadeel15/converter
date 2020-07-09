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
 * Service class for doing unit conversion validations.
 */
@Service
public class ConverionService {
	
	Logger logger = LoggerFactory.getLogger(ConverionService.class);
	
	final String CORRECT_RESULT = "Correct";
	final String INCORRECT_RESULT = "Incorrect";
	final String INVALID_RESULT = "Invalid";
	final Double THRESHOLD_ERROR =0.1;
	
	@Autowired
	UnitConversionService unitConversionService ;
	
	public ConverionService() {
		super();
	}

	/**
	 * Function to unit conversion using  service then compare result with value  enter by user
	 * It is accepting threshold error of 0.1
	 * @param data
	 * @return Return string of type 
	 * 			Correct: When conversion is done correctly
	 *          Incorrect: When conversion is not done correctly
	 *          Invalid: Input data is invalid
	 */
	public String convert(ConversionData data) 
	{
		
		try {
			Double inputValue = Double.parseDouble(data.getInputValueString());
			Double responseValue = Double.parseDouble(data.getResponseValueString());
			
			//round user response to tenth unit
			responseValue =  Math.round(responseValue* 10D) / 10D;
			logger.trace("ConverionService...after rounding  = "+responseValue);
			
			/// Perform unit conversion
			Double actualResultDouble = unitConversionService.convert(data.getInputUnitString(),  inputValue, data.getOutputUnitString());
			logger.trace("ConverionService...actual value from user = "+actualResultDouble);
			
			
			///Check calculated value equal to target value, iff there is different of 0.1 then ignore it
			if( Math.abs(actualResultDouble.doubleValue() - responseValue.doubleValue() ) <= THRESHOLD_ERROR.doubleValue()){
				return CORRECT_RESULT;
			}
			else {
				return INCORRECT_RESULT;
			}
		}
		catch (IllegalArgumentException | NullPointerException  e) {
			logger.error(e.getMessage());
			return INVALID_RESULT;
		}	
	}
	
	/**
	 * 
	 * @param datalist
	 * 
	 *  Function to perform validation operation on list of data objects
	 */
	public void convertDataList(ConversionDataDTO datalist) 
	{
		for(ConversionData data: datalist.getConversionDatas())
		{
			data.setResultString(convert(data));
		}
	}
	

}
