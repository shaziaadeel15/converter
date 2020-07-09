package com.converter.models.utilities;

/**
 * 
 * @author shaziaadeel
 *  Unit factory create Unit object of given type
 */
public class UnitFactory {
	
	public static Unit buildUnit(String name) throws IllegalArgumentException
	{
		name = name.toLowerCase();
		
		///Create units of type volume
		if(name.equals("liter") || name.equals("liters"))
			return new VolumeUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.equals("cubic-inch") || name.equals("cubic-inches"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 0.55411, 0.0);
		else if(name.equals("cup") || name.equals("cups"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 8.0, 0.0);
		else if(name.equals("gallon") || name.equals("gallons"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 128.0, 0.0);
		else if(name.equals("cubic-feet") || name.equals("cubic-foot"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 957.506, 0.0);
		else if(name.equals("tablespoon") || name.equals("tablespoons"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 0.5, 0.0);
		
		///Create units of type temperature
		else if(name.equals("celcius") )
			return new TemperatureUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.equals("kelvin") )
			return new TemperatureUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 273.15);
		else if(name.equals("fahrenheit") )
			return new TemperatureUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.equals("rankine") )
			return new TemperatureUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 1.0, 459.67);
		
		throw new IllegalArgumentException("Invalid argument");
		
	}

}
