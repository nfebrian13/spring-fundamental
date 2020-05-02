package com.core.spring;

import com.core.spring.model.Title;

/** 
 * Konsep Depedency injection
 * Berikut contoh DI dengan menggunakan 2 cara yaitu:
 * 1. setter injection
 * 2. constructor injection
 * 
 * */


public class MainClass {

	public static void main(String[] args) {
		exampleSetterInjection();
	}

	public static void exampleSetterInjection() {
		// Creating the title of the book
		// Step 1: Instantiate the object by calling no-argument constructor
		Title bookTitle = new Title();
		// Step 2: Call the setter method to set title value
		bookTitle.setTitleValue("My First Spring Book"); // Setter method
	}

	public static void exampleConstructorInjection() {
		// Creating the titles of the chapters by calling one-argument constructor
		Title chapter1Title = new Title("Spring framework - Chapter 1");
		Title chapter2Title = new Title("Spring framework - Chapter 2");
	}
}
