package com.mvc.hello.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mvc.hello.spring.model.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	private Logger logger = Logger.getLogger(RegisterController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);

		List<String> professionList = new ArrayList<>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		model.put("professionList", professionList);

		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {

		logger.info("username: " + user.getUsername());
		logger.info("password: " + user.getPassword());
		logger.info("email: " + user.getEmail());
		logger.info("birth date: " + user.getBirthDate());
		logger.info("profession: " + user.getProfession());

		return "registrationSuccess";
	}
}