package com.mvc.hello.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/doMath")
public class MathController {

	private Logger logger = Logger.getLogger(MathController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView calculateSum(@RequestParam int a, @RequestParam int b) {
		ModelAndView model = new ModelAndView("mathResult");

		model.addObject("sum", (a + b));
		model.addObject("subtract", (a - b));
		model.addObject("multiply", (a * b));
		model.addObject("divide", (a / b));

		return model;
	}

}