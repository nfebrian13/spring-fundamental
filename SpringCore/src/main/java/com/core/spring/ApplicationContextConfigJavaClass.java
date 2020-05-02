package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.spring.config.BeansConfiguration;
import com.core.spring.model.Book;
import com.core.spring.model.Chapter;
import com.core.spring.model.Title;

/**
 * Berikut adalah contoh untuk memanggil DI yang telah dikonfigurasi di java
 * (java based configuration)
 * 
 */

public class ApplicationContextConfigJavaClass {

	public static void main(String[] args) {

		/* Calling Tittle */
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		Title setterInjection = (Title) context.getBean("bookTitle"); /* bookTitle => id object di xml beans */
		Title constructorInjection = (Title) context.getBean("chapter1Title");

		System.out.println(constructorInjection.getTitleValue());

		/* injecting the dependencies of chapter 1 by setter method */
		Chapter chapter1 = (Chapter) context.getBean("chapter1");
		System.out.println(chapter1.getContent());
		System.out.println(chapter1.getTitle().getTitleValue());

		System.out.println();

		/* injecting the dependencies of chapter 1 by setter method */
		Chapter chapter2 = (Chapter) context.getBean("chapter2");
		System.out.println(chapter2.getContent());
		System.out.println(chapter2.getTitle().getTitleValue());

		System.out.println();
		System.out.println("--MY FIIRST BOOK--");
		Book myFirstSpringBook = (Book) context.getBean("myFirstSpringBook");
		System.out.println(myFirstSpringBook.getAuthor());
		System.out.println(myFirstSpringBook.getTitle().getTitleValue());
		System.out.println(myFirstSpringBook.getIsbn());

		for (Chapter c : myFirstSpringBook.getChapters()) {
			System.out.println(c.getNumber());
			System.out.println(c.getContent());
		}

	}

}
