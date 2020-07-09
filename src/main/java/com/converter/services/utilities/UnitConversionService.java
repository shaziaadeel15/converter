package com.converter.services.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.converter.models.utilities.TemperatureUnit;
import com.converter.models.utilities.Unit;
import com.converter.models.utilities.UnitFactory;
import com.converter.models.utilities.VolumeUnit;
import com.converter.services.ConverionService;

/**
 * 
 * @author shaziaadeel
 *
 */

@Service
public class UnitConversionService {
	
	Logger logger = LoggerFactory.getLogger(UnitConversionService.class);
	public UnitConversionService() {
	}
	
	/**
	 * Function for doing unit conversion.
	 *  First check if both input and output unit same then no need of doing conversion
	 *  In case source and target units are form different unit system like one from volume other from temperature then return error
	 *  For volume unit value must be greater than equal to zero
	 *  In end after conversion round value to tenth place
	 * @param inputUnitString
	 * @param inputValue
	 * @param outputUnitString
	 * @return
	 */
	public Double convert(String inputUnitString, Double inputValue, String outputUnitString)
	{
		if(inputUnitString==null 
				|| inputValue==null || outputUnitString==null)
			throw new IllegalArgumentException("Illegel Argument");
		
		Double resultDouble = inputValue;
		Unit sourceUnit = UnitFactory.buildUnit( inputUnitString );
		Unit targetUnit = UnitFactory.buildUnit( outputUnitString );
		
		
		//if both units are same then do nothing
		if(sourceUnit.getNameString().equals(targetUnit.getNameString()))
		{
			
			logger.trace("UnitConversionService....both units are same"+inputUnitString+" -> "+outputUnitString);
			return resultDouble;
		}
		
		//If input and out units are from different system then return error
		if(sourceUnit.getTypeString().equals(targetUnit.getTypeString()) == false)
		{
			System.out.println("convert...different type units");
			logger.error("UnitConversionService...."+inputUnitString+" -> "+outputUnitString+" conversion not possible");
			throw new IllegalArgumentException("Both unit are of different type, conversion is not possible");
		}
		
		
		/// If source unit is of type volume then input value must be greater than or equal to  0
		if(sourceUnit instanceof VolumeUnit  && inputValue < 0.0 )
		{
			System.out.println("convert...volume unit cannot be less than 0");
			logger.error("UnitConversionService...."+inputUnitString+" has value "+inputValue+" less than zero");
			throw new IllegalArgumentException("UnitConversionService...."+inputUnitString+" has value "+inputValue+" less than zero");
		}
		
		//multiple by source anchor
		resultDouble = resultDouble * sourceUnit.getAnchorDouble();
		
		//add sour e anchor shift
		resultDouble = resultDouble - sourceUnit.getAnchorShiftDouble();
		
		//conversion between metric and imperial systems
		if(sourceUnit.getSystemString().equals(targetUnit.getSystemString()) ==false)
		{
			resultDouble =  sourceUnit.toBase(resultDouble);
			/*
			//type is temperature then apply transfer function
			if (sourceUnit instanceof TemperatureUnit) {
				resultDouble =  ((TemperatureUnit) sourceUnit).transfer(resultDouble);
			}
			//type is volume apply ratio function
			else {
				resultDouble =  ((VolumeUnit) sourceUnit).applyRatio(resultDouble);
			}*/
		}
		
		//add destination anchor shift
		resultDouble = resultDouble + targetUnit.getAnchorShiftDouble();
		
		//multiple by destination anchor
		resultDouble = resultDouble / targetUnit.getAnchorDouble();
		
		/// round to tenth decimal places
		resultDouble = Math.round(resultDouble * 10D) / 10D;
		
		return resultDouble;
		
	}

}
