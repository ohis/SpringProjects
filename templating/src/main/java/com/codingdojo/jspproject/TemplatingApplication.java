package com.codingdojo.jspproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@Controller
public class TemplatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplatingApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
}
