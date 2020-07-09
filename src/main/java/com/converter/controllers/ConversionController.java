package com.converter.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.converter.models.ConversionDataDTO;
import com.converter.models.FileData;
import com.converter.services.ConverionService;

/**
 * 
 * @author shaziaadeel
 * Controller for conversion module handling
 */
@Controller
public class ConversionController {
	
	Logger logger = LoggerFactory.getLogger(ConversionController.class);
	
	///Service checking unit conversion
	@Autowired
	ConverionService conversionService;
	
	//Default mapper
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String convert( Model model)
	{
		ConversionDataDTO form = new ConversionDataDTO();
		form.addEmptyConversionData();
		
		logger.info("empty rows="+form.getConversionDatas().size());
		model.addAttribute("form", form);
		model.addAttribute("fileData", new FileData());
		
		return "conversion";
	}
	
	
	///Post mapper, called when user click upload button
	@PostMapping("/")
	public ModelAndView isValidResult(@ModelAttribute ConversionDataDTO form, @ModelAttribute FileData fileData, @RequestParam String action)//, Model model)
	{
		logger.info("Post"+form.getConversionDatas().size());
		logger.info("Action ="+ action);
		
		if(action.equals("check"))
		{
			///Call service to perform conversion on input data
			conversionService.convertDataList(form);
		}
		else if(action.equals("addrow"))
		{
			form.addEmptyConversionData();
		}
		
		Map<String, Object> params = new HashMap<>();
		params.put("form", form);
		
		//params.put("fileData", new FileData());
		return  new ModelAndView("conversion", params);	
	}
	
}
