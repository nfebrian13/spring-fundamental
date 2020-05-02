package com.core.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.spring.model.Title;

@Configuration
public class BeansConfiguration {

	@Bean
	public Title bookTitle() {
		Title title = new Title();
		title.setTitleValue("My first Spring book");
		return title;
	}

	@Bean
	public Title chapter1Title() {
		return new Title("Spring framework - Chapter 1");
	}

	@Bean
	public Title chapter2Title() {
		return new Title("Spring framework - Chapter 2");
	}

}