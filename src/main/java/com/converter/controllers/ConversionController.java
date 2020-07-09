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
 * Controller for handling validation of data 
 */
@Controller
public class ConversionController {
	
	Logger logger = LoggerFactory.getLogger(ConversionController.class);
	final String MAIN_PAGE = "conversion";
	
	final String CHECK_DATA_ACTION = "check";
	final String ADD_ROW_ACTION = "addrow";
	
	///Add object of unit conversion service
	@Autowired
	ConverionService conversionService;
	
	/**
	 * Called when application is load and data is reset
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String load( Model model)
	{
		/// Create new DTO object
		ConversionDataDTO form = new ConversionDataDTO();
		
		// Add one empty row
		form.addEmptyConversionData();
		
		logger.info("empty rows="+form.getConversionDatas().size());
		
		/// Pass it as model attribute
		model.addAttribute("form", form);
		model.addAttribute("fileData", new FileData());
		
		return MAIN_PAGE;
	}
	
	/**
	 * Controller function is invoke when user click "Check Data" or "Add Row" button
	 * @param form
	 * @param fileData
	 * @param action it can be "check" or "addrow"
	 * @return
	 */
	@PostMapping("/")
	public ModelAndView isValidResult(@ModelAttribute ConversionDataDTO form, @ModelAttribute FileData fileData, @RequestParam String action)//, Model model)
	{
		logger.info("Post"+form.getConversionDatas().size());
		logger.info("Action ="+ action);
		
		if(action.equals(CHECK_DATA_ACTION))
		{
			///Call service to perform validation on input data
			conversionService.convertDataList(form);
		}
		else if(action.equals(ADD_ROW_ACTION))
		{
			//add an empty row
			form.addEmptyConversionData();
		}
		
		Map<String, Object> params = new HashMap<>();
		params.put("form", form);
		
		//params.put("fileData", new FileData());
		return  new ModelAndView(MAIN_PAGE, params);	
	}
	
}
