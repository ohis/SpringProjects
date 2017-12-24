package com.codingdojo.human.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String index( @RequestParam(value="q",defaultValue="Human") String query, Model model) {
		System.out.println(query);
		model.addAttribute("query", query);
		return "welcome";
	}

}
