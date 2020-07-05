package com.pluralsight.test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordHash extends TestCase {
	
	public void testBcrycptHash() {
		String password = "secret";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hassedPassword = passwordEncoder.encode(password);
		System.out.println(hassedPassword);
	}

	public void testMD5Hash() {
		String password = "secret";
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String hassedPassword = passwordEncoder.encodePassword(password, null);
		System.out.println(hassedPassword);
	}
}
