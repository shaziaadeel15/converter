package com.converter.models;

/**
 * 
 * @author shaziaadeel
 * Model class representing single row of input data on web oage
 */
public class ConversionData {
	
	//Input value
	private String inputValueString;
	
	//Input Unit
	private String inputUnitString;
	
	//Student response
	private String responseValueString;
	
	// Output Unit
	private String outputUnitString;
	
	// Result after processing data, it can contain values "correct", "incorrect, "invalid"
	private String resultString;
	
	public ConversionData(String inputValueString, String inputUnitString,  String responseValueString, String outputUnitString ) 
	{
		super();
		this.inputUnitString = inputUnitString;
		this.outputUnitString = outputUnitString;
		this.inputValueString = inputValueString;
		this.responseValueString = responseValueString;
		this.resultString="";
	}
	
	/**
	 * 
	 */
	public ConversionData() {
		this.inputValueString="";
		this.inputUnitString="";
		this.responseValueString="";
		this.outputUnitString="";
		this.resultString="";
	}

	/*
	 * 
	 */
	public String getInputValueString() {
		return inputValueString;
	}

	public void setInputValueString(String inputValueString) {
		this.inputValueString = inputValueString;
	}

	public String getInputUnitString() {
		return inputUnitString;
	}

	public void setInputUnitString(String inputUnitString) {
		this.inputUnitString = inputUnitString;
	}

	public String getResponseValueString() {
		return responseValueString;
	}

	public void setResponseValueString(String responseValueString) {
		this.responseValueString = responseValueString;
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
	
	
}
