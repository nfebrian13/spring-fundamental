package com.embeed.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private String emailAddress;

	// Default constructor.
	public Student() {
	}

	// Parameterized constructor.
	public Student(int id, String name, int age, String emailAddress) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	// Getters.
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
}
