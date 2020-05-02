package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.core.spring.model.Chapter;
import com.core.spring.model.Title;

/** 
 * Berikut adalah contoh untuk memanggil DI yang telah dikonfigurasi di xml (xml based configuration)
 * context.getBean("chapter1") => nama dari beans id di xml config
 * */

public class ApplicationContextMainClass {

	public static void main(String[] args) {
		
		/* Calling Tittle 
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("com/core/spring/config/title-beans.xml");
		Title setterInjection = (Title) springContainer.getBean("bookTitle"); 
		Title constructorInjection = (Title) springContainer.getBean("chapter1Title");
		System.out.println(constructorInjection.getTitleValue());  */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/core/spring/config/beans.xml");
		Chapter chapter = (Chapter) context.getBean("chapter1");
		System.out.println(chapter.getContent());
		System.out.println(chapter.getTitle().getTitleValue());
		
	}

}
