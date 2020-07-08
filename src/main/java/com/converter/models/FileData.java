package com.converter.models;

import org.springframework.web.multipart.MultipartFile;

public class FileData {
	private String fileTypeString;
	private MultipartFile multipartFile;
	
	public FileData() {
		// TODO Auto-generated constructor stub
	}
	public String getFileTypeString() {
		return fileTypeString;
	}
	public void setFileTypeString(String fileTypeString) {
		this.fileTypeString = fileTypeString;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
}
