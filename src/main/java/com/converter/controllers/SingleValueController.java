package com.converter.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.converter.models.ConversionData;
import com.converter.services.ConverionService;

@Controller
public class SingleValueController {

	@Autowired
	ConverionService conversionService;

	
	@GetMapping("/singlevalue")
	public String home(@ModelAttribute("data") ConversionData data)
	{
		return "home";
	}
	
	@ModelAttribute("data")
	public ConversionData  conversionData() {
		return new ConversionData();
	}
	
	@PostMapping("/singlevalue")
	public ModelAndView isValid(@ModelAttribute("data") ConversionData data)
	{
		String resultString = conversionService.convert(data);
		System.out.println("result="+resultString);
		data.setResultString(resultString);
		System.out.println("in unit ="+data.getInputUnitString());
		Map<String, Object> params = new HashMap<>();

		return  new ModelAndView("home", params);
			
	}
	

}
