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
		
		/* injecting the dependencies of chapter 1 by setter method */
		ApplicationContext context = new ClassPathXmlApplicationContext("com/core/spring/config/beans.xml");
		Chapter chapter1 = (Chapter) context.getBean("chapter1");
		System.out.println(chapter1.getContent());
		System.out.println(chapter1.getTitle().getTitleValue());
		
		/* injecting the dependencies of chapter 2 using constructor by index */
		Chapter chapter2 = (Chapter) context.getBean("chapter2");
		System.out.println(chapter2.getContent());
		System.out.println(chapter2.getTitle().getTitleValue());
		
	}

}
