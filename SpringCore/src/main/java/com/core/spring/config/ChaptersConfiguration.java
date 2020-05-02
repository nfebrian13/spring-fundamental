package com.core.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.core.spring.model.Chapter;
import com.core.spring.model.Title;

@Import(TitlesConfiguration.class)
@Configuration
public class ChaptersConfiguration {
	
	@Autowired Title chapter1Title;
	@Autowired Title chapter2Title;
	
	@Bean
	public Chapter chapter1() {
		// Injecting the dependencies using setter method
		Chapter chapter = new Chapter();
		chapter.setContent("The content of chapter 1 goes here.");
		chapter.setNumber(1);
		chapter.setTitle(chapter1Title);
		return chapter;
	}

	@Bean
	public Chapter chapter2() {
		// Injecting the dependencies of chapter2 using constructor method
		return new Chapter(2, chapter2Title, "The content of chapter 2 goes here.");
	}

}