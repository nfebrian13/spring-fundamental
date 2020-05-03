package com.mvc.hello.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	private Logger logger = Logger.getLogger(FileUploadController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String doFileUpload(@RequestParam int a) throws IOException, SQLException {

		logger.info("This is an info log entry");
		logger.error("This is an error log entry");
		
		// handles file upload stuff...
		if (a == 1) {
			throw new IOException("Could not read upload file.");
		} else if (a == 2) {
			throw new SQLException("Database exception!!!");
		}
		return "done";
	}

	@ExceptionHandler({ IOException.class, java.sql.SQLException.class })
	public ModelAndView handleIOException(Exception ex) {
		ModelAndView model = new ModelAndView("IOError");
		model.addObject("exception", ex.getMessage());
		return model;
	}
}
