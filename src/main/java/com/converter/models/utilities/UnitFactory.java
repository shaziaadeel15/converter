package com.converter.models.utilities;

/**
 * 
 * @author shaziaadeel
 *  Unit factory create Unit object of given type
 */
public class UnitFactory {
	
	public static Unit buildUnit(String name) throws IllegalArgumentException
	{
		if(name.toLowerCase().equals("liter") || name.toLowerCase().equals("liters"))
			return new VolumeUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.toLowerCase().equals("cubic-inch") || name.toLowerCase().equals("cubic-inches"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 0.55411, 0.0);
		else if(name.toLowerCase().equals("cup") || name.toLowerCase().equals("cups"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 8.0, 0.0);
		else if(name.toLowerCase().equals("gallon") || name.toLowerCase().equals("gallons"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 128.0, 0.0);
		else if(name.toLowerCase().equals("cubic-feet") || name.toLowerCase().equals("cubic-foot"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 957.506, 0.0);
		else if(name.toLowerCase().equals("tablespoon") || name.toLowerCase().equals("tablespoons"))
			return new VolumeUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 0.5, 0.0);
		
		else if(name.toLowerCase().equals("celcius") )
			return new TemperatureUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.toLowerCase().equals("kelvin") )
			return new TemperatureUnit(SystemTypes.METRIC_SYSTEM_STRING, name, 1.0, 273.15);
		else if(name.toLowerCase().equals("fahrenheit") )
			return new TemperatureUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 1.0, 0.0);
		else if(name.toLowerCase().equals("rankine") )
			return new TemperatureUnit(SystemTypes.IMPERIAL_SYSTEM_STRING, name, 1.0, 459.67);
		
		throw new IllegalArgumentException("Invalid argument");
		
	}

}
