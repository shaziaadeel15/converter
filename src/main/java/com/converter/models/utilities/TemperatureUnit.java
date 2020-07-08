package com.converter.models.utilities;

/**
 * 
 * @author shaziaadeel
 * Unit of type temperature 
 */
public class TemperatureUnit extends Unit{
	
	/**
	 * 
	 * @param systemString
	 * @param nameString
	 * @param anchorDouble
	 * @param anchorShiftDouble
	 */
	TemperatureUnit( String systemString, String nameString, Double anchorDouble,
			Double anchorShiftDouble)
	{
		super( UnitTypes.TEMPERATURE_STRING, systemString, nameString, anchorDouble, anchorShiftDouble);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public Double transfer(Double value)
	{
		if(this.getSystemString().equals(SystemTypes.METRIC_SYSTEM_STRING)) {
			return value / (5.0/9.0) + 32.0;
		}
		else {
			return (value - 32.0)* (5.0 /9.0);
			
		}
	}

}
