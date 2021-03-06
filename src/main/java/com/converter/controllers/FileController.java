package com.converter.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.converter.models.ConversionDataDTO;
import com.converter.models.FileData;
import com.converter.services.FileService;

/**
 * 
 * @author shaziaadeel
 * Controller for loading file operation
 */
@Controller
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(FileController.class);
	
	//Service for uploading file
	@Autowired
	FileService readfileService;
	
	/**
	 * Invoke when user click "Upload" button, it get file data and use FileService to add data in DTO object
	 * @param fileData
	 * @return
	 */
	@PostMapping("/fileupload")
	public ModelAndView uploadFile(@ModelAttribute FileData fileData)
	{
		///Map for sending model
		Map<String, Object> params = new HashMap<>();
		
		// Error checking
		if(fileData == null || fileData.getMultipartFile() == null)
		{
			logger.error("file ="+fileData.getFileTypeString());
			logger.error("File attribute is null");
			return  new ModelAndView("error");
		}
		
		try {
			
			ConversionDataDTO form = readfileService.readDataFromFile(fileData.getMultipartFile());
			if(form==null)
			{
				logger.error("Error in reading file");
				params.put("failmsg","File uploading fail, Please try again");
			}
			params.put("form", form);
		}
		catch(FileUploadException  e)
		{
			logger.error("File uploading fail");
			params.put("failmsg",e.getMessage().length() <= 0 ? "File uploading fail": e.getMessage());
			
		}
		 return  new ModelAndView("conversion", params);
	}

}
