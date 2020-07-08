package com.converter.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shaziaadeel
 *
 */
public class ConversionDataDTO {
	
	/// List of conversion values, each list item represent as single record
	private List<ConversionData> conversionDatas;
	
	public ConversionDataDTO() {
		conversionDatas = new ArrayList<ConversionData>();
	}
	
	/// List new record
	public void addConversionData(Double inputValue, String inputUnit,  Double outputValue, String outputUnit)
	{
		this.conversionDatas.add(new ConversionData(inputValue, inputUnit, outputValue, outputUnit));
	}

	/// Getter
	public List<ConversionData> getConversionDatas() {
		return conversionDatas;
	}

	///Setter
	public void setConversionDatas(List<ConversionData> conversionDatas) {
		this.conversionDatas = conversionDatas;
	}
}
