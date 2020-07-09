package com.converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author shaziaadeel
 *
 */
@Controller
public class ErrorController 
{
	
	final String ERROR_PAGE = "error";
	/**
	 * 
	 * @return
	 */
	@GetMapping("/error")
	public String error()
	{
		return ERROR_PAGE;
	}
}
