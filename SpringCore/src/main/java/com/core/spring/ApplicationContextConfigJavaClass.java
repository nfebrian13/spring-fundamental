package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.spring.config.BeansConfiguration;
import com.core.spring.model.Title;

/**
 * Berikut adalah contoh untuk memanggil DI yang telah dikonfigurasi di java
 * (java based configuration)
 * 
 */

public class ApplicationContextConfigJavaClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		Title setterInjection = (Title) context.getBean("bookTitle"); /* bookTitle => id object di xml beans */
		Title constructorInjection = (Title) context.getBean("chapter1Title");

		System.out.println(constructorInjection.getTitleValue());
	}

}
