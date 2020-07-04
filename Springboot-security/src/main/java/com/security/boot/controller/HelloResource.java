package com.security.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.access.prepost.PreAuthorize;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

	@GetMapping("/all")
	public String hello() {
		return "Hello Youtube";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello() {
		System.out.println("wkwk");
		return "hello";
	}

	@GetMapping("/secured/alternate")
	public String alternate() {
		return "alternate";
	}

}
