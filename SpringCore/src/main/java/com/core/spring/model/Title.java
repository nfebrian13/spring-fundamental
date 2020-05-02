package com.core.spring.model;

/** 
 * Ada 2 cara untuk membuat object (instantiated) 'title'
 * 1. Using no-argument constructor followed by setter method
 * 2.  Using constructor with argument
 */

public class Title {
	private String titleValue;

	public Title() {
	}

	public Title(String titleValue) {
		this.titleValue = titleValue;
	}

	public String getTitleValue() {
		return titleValue;
	}

	public void setTitleValue(String titleValue) {
		this.titleValue = titleValue;
	}
}
