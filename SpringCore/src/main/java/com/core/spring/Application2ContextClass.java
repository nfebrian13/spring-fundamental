package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.spring.config.BooksConfiguration;
import com.core.spring.model.Book;
import com.core.spring.model.Chapter;

public class Application2ContextClass {
	public static void main(String[] args) {
		/* Calling Tittle */
		ApplicationContext context = new AnnotationConfigApplicationContext(BooksConfiguration.class);

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
