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
		
		/* Calling Tittle */
		ApplicationContext context = new ClassPathXmlApplicationContext("com/core/spring/config/beans.xml"); 
		
		Title constructorInjection = (Title) context.getBean("chapter1Title");
		System.out.println(constructorInjection.getTitleValue());  
		
		/* injecting the dependencies of chapter 1 by setter method */
		Chapter chapter1 = (Chapter) context.getBean("chapter1");
		System.out.println(chapter1.getContent());
		System.out.println(chapter1.getTitle().getTitleValue());
		
		System.out.println();
		
		/* injecting the dependencies of chapter 2 using constructor by index */
		Chapter chapter2 = (Chapter) context.getBean("chapter2");
		System.out.println(chapter2.getContent());
		System.out.println(chapter2.getTitle().getTitleValue());
		
		System.out.println();
		
		/*  injecting the dependencies of chapter 3 using constructor by type */
		Chapter chapter3 = (Chapter) context.getBean("chapter3");
		System.out.println(chapter3.getContent());
		System.out.println(chapter3.getTitle().getTitleValue());
		
		System.out.println();
		
		/*  injecting the dependencies of chapter 1 by using inner bean */
		Chapter chapter4 = (Chapter) context.getBean("chapter4");
		System.out.println(chapter4.getContent());
		System.out.println(chapter4.getTitle().getTitleValue());
	}

}
