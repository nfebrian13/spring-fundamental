package com.mvc.hello.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {

	private Logger logger = Logger.getLogger(FileUploadController.class);

	private String saveDirectory = "E:/logs/upload/";
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String test(Model model) {
		return "uploadForm";
	}
	
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
         
    	logger.info("description: " + request.getParameter("description"));
         
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
            	logger.info("Saving file: " + aFile.getOriginalFilename());
                if (!aFile.getOriginalFilename().equals("")) {
                    aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
                }
            }
        }
 
        return "result";
    }
}
