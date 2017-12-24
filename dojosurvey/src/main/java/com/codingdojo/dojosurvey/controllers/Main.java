package com.codingdojo.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
	private String name;
	private String loc;
	private String comment;
	private String language;
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/results")
	public String resultPage(Model model) {
      model.addAttribute("name", name);
      model.addAttribute("location", loc);
      model.addAttribute("comment", comment);
      model.addAttribute("language", language);
      System.out.println("name is :"+name);
      System.out.println("my location is :"+loc);
      System.out.println("my comment is :"+comment);
      System.out.println("my fave lang is "+language);
		return "result";
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="comment") String comment, 
	@RequestParam(value="language") String lang ,Model model) {
		this.name = name;
		this.loc = location;
		this.comment = comment;
		this.language = lang;
		return "redirect:/results";
		
	}
}
