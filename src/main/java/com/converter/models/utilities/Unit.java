package com.converter.models.utilities;


/**
 * 
 * @author shaziaadeel
 * Class representing single unit object
 */
public class Unit {
	
	String typeString;
	String systemString;
	String nameString;
	Double anchorDouble;
	Double anchorShiftDouble;
	
	
	public Unit(String typeString, String systemString, String nameString, Double anchorDouble,
			Double anchorShiftDouble) {
		this.typeString = typeString;
		this.systemString = systemString;
		this.nameString = nameString;
		this.anchorDouble = anchorDouble;
		this.anchorShiftDouble = anchorShiftDouble;
	}
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	public String getSystemString() {
		return systemString;
	}
	public void setSystemString(String systemString) {
		this.systemString = systemString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Double getAnchorDouble() {
		return anchorDouble;
	}
	public void setAnchorDouble(Double anchDouble) {
		this.anchorDouble = anchDouble;
	}
	public Double getAnchorShiftDouble() {
		return anchorShiftDouble;
	}
	public void setAnchorShiftDouble(Double anchShiftDouble) {
		this.anchorShiftDouble = anchShiftDouble;
	}
	
}
