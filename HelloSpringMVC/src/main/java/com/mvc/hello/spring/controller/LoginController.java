package com.mvc.hello.spring.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.hello.spring.model.Person;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model) {
		Person person = new Person();
		model.put("personForm", person);
		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("personForm") Person personForm, BindingResult result,
			Map<String, Object> model) {

		if (result.hasErrors()) {
			return "loginForm";
		}

		return "loginSuccess";
	}
}