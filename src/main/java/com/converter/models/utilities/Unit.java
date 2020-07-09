package com.converter.models.utilities;


/**
 * 
 * @author shaziaadeel
 * Class representing single unit object
 */
public abstract class Unit {
	
	String typeString;
	String systemString;
	String nameString;
	Double anchorDouble;
	Double anchorShiftDouble;
	
	/**
	 * 
	 * @param typeString
	 * @param systemString
	 * @param nameString
	 * @param anchorDouble
	 * @param anchorShiftDouble
	 */
	public Unit(String typeString, String systemString, String nameString, Double anchorDouble,
			Double anchorShiftDouble) {
		this.typeString = typeString;
		this.systemString = systemString;
		this.nameString = nameString;
		this.anchorDouble = anchorDouble;
		this.anchorShiftDouble = anchorShiftDouble;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * 
	 * Abstract class to transferring each unit to its base value
	 * 
	 */
	public abstract Double toBase(Double value);
	
	/**
	 * 
	 * @return
	 */
	public String getTypeString() {
		return typeString;
	}
	
	/**
	 * 
	 * @param typeString
	 */
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSystemString() {
		return systemString;
	}
	
	/**
	 * 
	 * @param systemString
	 */
	public void setSystemString(String systemString) {
		this.systemString = systemString;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNameString() {
		return nameString;
	}
	
	/**
	 * 
	 * @param nameString
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getAnchorDouble() {
		return anchorDouble;
	}
	
	/**
	 * 
	 * @param anchDouble
	 */
	public void setAnchorDouble(Double anchDouble) {
		this.anchorDouble = anchDouble;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getAnchorShiftDouble() {
		return anchorShiftDouble;
	}
	
	/**
	 * 
	 * @param anchShiftDouble
	 */
	public void setAnchorShiftDouble(Double anchShiftDouble) {
		this.anchorShiftDouble = anchShiftDouble;
	}
	
}
