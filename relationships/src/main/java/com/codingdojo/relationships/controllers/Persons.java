package com.codingdojo.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.DMVService;
@Controller
public class Persons {
	private final DMVService dmv;
	public Persons(DMVService dmv) {
		this.dmv = dmv;
	}
	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("Createperson") Person person) {
		return "newPerson";
	}
	
	@PostMapping("/createP")
	public String createPerson(@Valid @ModelAttribute("Createperson") Person person, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "newPerson";
		}else {
			dmv.addPerson(person);
			System.out.println(person.getFirstName());
			return "redirect:/persons/new";
		}
		
	}
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		model.addAttribute("person", dmv.getPerson(id));
		return "profile";
	}

}
