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
	 * 
	 * @param sourceString
	 * @param sourceValueDouble
	 * @param targetString
	 * @return
	 */
	public Double convert(String sourceString, Double sourceValueDouble, String targetString)
	{
		
		if(sourceString==null 
				|| sourceValueDouble==null || targetString==null)
			throw new IllegalArgumentException("Illegel Argument");
		
		Double resultDouble = sourceValueDouble;
		Unit sourceUnit = UnitFactory.buildUnit( sourceString );
		Unit targetUnit = UnitFactory.buildUnit( targetString );
		
		//if both units are same then do nothing
		if(sourceUnit.getNameString().equals(targetUnit.getNameString()))
		{
			logger.trace("UnitConversionService....both units are same"+sourceString+" -> "+targetString);
			return resultDouble;
		}
		
		if(sourceUnit.getTypeString().equals(targetUnit.getTypeString()) == false)
		{
			logger.error("UnitConversionService...."+sourceString+" -> "+targetString+" conversion not possible");
			throw new IllegalArgumentException("Both unit are of different type, conversion is not possible");
		}
		
		//multiple by source anchor
		resultDouble = resultDouble * sourceUnit.getAnchorDouble();
		
		//add sour e anchor shift
		resultDouble = resultDouble - sourceUnit.getAnchorShiftDouble();
		
		//conversion between metric and imperial systems
		if(sourceUnit.getSystemString().equals(targetUnit.getSystemString()) ==false)
		{
			//type is temperature then apply transfer function
			if (sourceUnit instanceof TemperatureUnit) {
				resultDouble =  ((TemperatureUnit) sourceUnit).transfer(resultDouble);
			}
			//type is volume apply ratio function
			else {
				resultDouble =  ((VolumeUnit) sourceUnit).applyRatio(resultDouble);
			}
		}
		
		//add destination anchor shift
		resultDouble = resultDouble + targetUnit.getAnchorShiftDouble();
		
		//multiple by destination anchor
		resultDouble = resultDouble / targetUnit.getAnchorDouble();
		
		/// round to 4 decimal places
		resultDouble = Math.round(resultDouble * 10D) / 10D;
		
		return resultDouble;
		
	}

}
