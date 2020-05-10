package com.aop.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryServiceClient {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		LibraryService myLibraryService = (LibraryService) applicationContext.getBean("libraryServiceProxy");
		myLibraryService.issueBook(1, 1);
		myLibraryService.returnBook(2, 2);
		myLibraryService.addBook(3);
	}

}
