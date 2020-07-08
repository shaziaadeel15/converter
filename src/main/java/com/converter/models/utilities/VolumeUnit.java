package com.converter.models.utilities;

/**
 * 
 * @author shaziaadeel
 * Class for representing volume units
 */
public class VolumeUnit extends Unit{
	// Volume unit need ratio values
	private Double ratioDouble;
	
	/**
	 * 
	 * @param systemString
	 * @param nameString
	 * @param anchorDouble
	 * @param anchorShiftDouble
	 */
	public VolumeUnit(String systemString, String nameString, Double anchorDouble,
			Double anchorShiftDouble) 
	{
		super( UnitTypes.VOLUME_STRING, systemString, nameString, anchorDouble, anchorShiftDouble);
		if(this.systemString.equals(SystemTypes.METRIC_SYSTEM_STRING)) {
			this.ratioDouble =33.8140226;
		}	
		else {
			this.ratioDouble = (1.0)/(33.8146226);
		}
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public Double applyRatio(Double value)
	{
		return value * this.ratioDouble;
	}

}
