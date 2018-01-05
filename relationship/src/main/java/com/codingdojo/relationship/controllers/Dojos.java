package com.codingdojo.relationship.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.relationship.models.Dojo;
import com.codingdojo.relationship.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class Dojos {
	private DojoService dojoService;
	public Dojos(DojoService dojo) {
		this.dojoService = dojo;
	}
	@RequestMapping("/new")
	public String createDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "dojos/new";
	}
	
	@PostMapping("/create")
	public String createDojo(@Valid @ModelAttribute("newDojo") Dojo dojo,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("in errors");
		//	model.addAttribute("allDojos", dojoService.f)
			return "/new";
			
		}else {
			dojoService.createDojo(dojo);
			System.out.println(dojo.getName());
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("dojoNinja", dojoService.getDojo(id).getNinjas());
		model.addAttribute("dojo", dojoService.getDojo(id));
		return "/dojos/show";
		
	}

}
