package com.codingdojo.post.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
  private String name;
	@RequestMapping("/")
	public String Home() {
		System.out.println("got to home");
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("user", name);
		
		System.out.println("am in dash "+name);
		return "Dashboard";
	}
   @RequestMapping(path="/login", method=RequestMethod.POST)
   public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password,Model model)
   {
	   name = username;
	  System.out.println(username);
	  model.addAttribute("user", username);
	  return  "redirect:/dashboard";
   }
}
