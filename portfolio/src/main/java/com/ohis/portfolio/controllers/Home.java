package com.ohis.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
 
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	@RequestMapping("/me")
	public String about() {
		return "about.html";
	}
	@RequestMapping("/project")
	public String projects() {
		return "projects.html";
	}
}
