package com.codingdojo.session.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionAttribute")
public class Session {
	
	@ModelAttribute("sessionAttribute")
	public String getSession() {
		return "exampleDefaultData";
	}

	 @RequestMapping("/")
	 public String index(@ModelAttribute("sessionAttribute") String sessionAttribute) {
		 System.out.println(sessionAttribute);
		 return "index";
	 }
	 
	// @RequestMapping("/setSession")
	// public String setSession(Model model) {
	//	 model.addAttribute("sessionAttribute", "exampleData");
		// return "redirect:/";
	 //}
}
