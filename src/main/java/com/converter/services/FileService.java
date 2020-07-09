package com.converter.services;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.converter.models.ConversionDataDTO;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author shaziaadeel
 * FileService is used for providing service of parsing file data and fill DTO (Data Transfer Object) object
 */
@Service
public class FileService {
	
	Logger logger = LoggerFactory.getLogger(FileService.class);
    ConversionDataDTO datalist;
	
    FileService(){}

    /***
     * Service function accept a multipart file data, parse file and fill DTO object of type ConversionDataDTO
     * @param multipartFile
     * @return
     * @throws FileUploadException
     */
	public ConversionDataDTO readDataFromFile(MultipartFile multipartFile) throws FileUploadException 
	{
		///return error if input data is null
		if(multipartFile==null || multipartFile.getOriginalFilename().length() <= 0)
		{
			logger.error("User do not select a file");
			throw new FileUploadException("Please select a CSV file for uploading data");
		}
		
		//create new DTO object
		datalist = new ConversionDataDTO();
		String extensionString = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		
		//check extension, utility only support CSV file
		if(extensionString.equalsIgnoreCase("csv")==false)
		{
			logger.error("Not a valid csv file "+multipartFile.getOriginalFilename());
			throw new FileUploadException("Please select a CSV file for uploading data");
		}
		
		try{
			InputStreamReader reader = new InputStreamReader(multipartFile.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows = csvReader.readAll();
			
			logger.trace("readDataFromFile...rows length="+rows.size());
			
			///parse each row and add in DTO
			for(String[] row : rows) 
			{
				if(row.length<4)
				{
					logger.error("readDataFromFile...invalid row "+Arrays.toString(row));
					continue;
				}
				logger.trace("readDataFromFile...="+Arrays.toString(row));
				
				datalist.addConversionData(row[0], row[1], row[2], row[3] );
			}
			logger.trace("readDataFromFile...dataList length="+datalist.getConversionDatas().size());
			return datalist;
		}
		catch(Exception e) {
			throw new FileUploadException("File uploading fail");
		}
	}

}
