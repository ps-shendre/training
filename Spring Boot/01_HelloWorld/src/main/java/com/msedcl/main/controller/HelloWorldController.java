package com.msedcl.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetingapi")
public class HelloWorldController {
	// url= http://localhost:8080/greetingapi/greet
	// method =GET
	@GetMapping("greet")
	public String showMessage() {
		return "Welcome to spring boot training day-7";
	}

	// url= http://localhost:8080/greetingapi/process/{data}
	@GetMapping("process/{data}")
	public String processData(@PathVariable String data) {
		return data.toUpperCase();
	}
	// url= http://localhost:8080/greetingapi/display
	// method =POST
	
	@PostMapping("display")
	public String print() {
		return "Testing post mapping!";
	}
}
