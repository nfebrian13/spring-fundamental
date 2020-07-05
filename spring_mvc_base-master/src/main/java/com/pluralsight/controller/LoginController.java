package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("in the login method");
		return "login";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		System.out.println("in the login failed method");
		model.addAttribute("error", "true");
		return "login";
	}

}
