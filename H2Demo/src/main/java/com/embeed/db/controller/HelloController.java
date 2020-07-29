package com.embeed.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/name")
	public String helloMyName(Model model) {

		model.addAttribute("name", "Nana");
		return "index";
	}
}
