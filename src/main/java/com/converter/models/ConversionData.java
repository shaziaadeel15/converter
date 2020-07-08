package com.converter.models;

/**
 * 
 * @author shaziaadeel
 * Model class representing single row of input data
 */
public class ConversionData {
	
	//Input value
	private Double inputDouble;
	
	public Double getInputDouble() {
		return inputDouble;
	}

	public void setInputDouble(Double inputDouble) {
		this.inputDouble = inputDouble;
	}

	public String getInputUnitString() {
		return inputUnitString;
	}

	public void setInputUnitString(String inputUnitString) {
		this.inputUnitString = inputUnitString;
	}

	public Double getResponseDouble() {
		return responseDouble;
	}

	public void setResponseDouble(Double responseDouble) {
		this.responseDouble = responseDouble;
	}

	public String getOutputUnitString() {
		return outputUnitString;
	}

	public void setOutputUnitString(String outputUnitString) {
		this.outputUnitString = outputUnitString;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	//Input Unit
	private String inputUnitString;
	
	//Student response
	private Double responseDouble;
	
	// Output Unit
	private String outputUnitString;
	
	// Result after processing data, it can contain values "correct", "incorrect, "invalid"
	private String resultString;
	
	public ConversionData(Double inputDouble, String inputUnitString,  Double responseDouble, String outputUnitString ) 
	{
		super();
		this.inputUnitString = inputUnitString;
		this.outputUnitString = outputUnitString;
		this.inputDouble = inputDouble;
		this.responseDouble = responseDouble;
		this.resultString="";
	}
	
	public ConversionData() {
		this.inputDouble=0.0;
		this.inputUnitString="";
		this.responseDouble=0.0;
		this.outputUnitString="";
		this.resultString="";
	}
	
}
