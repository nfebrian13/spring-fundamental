package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.core.spring.model.Title;

/** 
 * Berikut adalah contoh untuk memanggil DI yang telah dikonfigurasi di xml (xml based configuration)
 * 
 * */

public class ApplicationContextMainClass {

	public static void main(String[] args) {
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("com/core/spring/config/beans.xml");
		Title setterInjection = (Title) springContainer.getBean("bookTitle"); /* bookTitle => id object di xml beans */ 
		Title constructorInjection = (Title) springContainer.getBean("chapter1Title");
		
		System.out.println(constructorInjection.getTitleValue());
	}

}
