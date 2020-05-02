package com.core.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.spring.model.Chapter;
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

	@Bean
	public Chapter chapter1() {
		// Injecting the dependencies using setter method
		Chapter chapter = new Chapter();
		chapter.setContent("The content of chapter 1 goes here.");
		chapter.setNumber(1);
		chapter.setTitle(chapter1Title());
		return chapter;
	}

	@Bean
	public Chapter chapter2() {
		// Injecting the dependencies of chapter2 using constructor method
		return new Chapter(2, chapter2Title(), "The content of chapter 2 goes here.");
	}

}