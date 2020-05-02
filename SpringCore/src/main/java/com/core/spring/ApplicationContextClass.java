package com.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.core.spring.model.Book;
import com.core.spring.model.Chapter;

public class ApplicationContextClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/core/spring/config/beans2.xml");
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
