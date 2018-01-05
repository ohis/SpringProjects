package com.codingdojo.relationship.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationship.models.Dojo;
import com.codingdojo.relationship.models.Ninja;
import com.codingdojo.relationship.services.DojoService;
import com.codingdojo.relationship.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class Ninjas {
	
	@InitBinder
	  public void initBinder(WebDataBinder binder) {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		  dateFormat.setLenient(false);
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	  }
	NinjaService ninjaServ;
	DojoService dojoServ;
    public Ninjas(NinjaService ninja,DojoService dojo) {
    	this.ninjaServ = ninja;
    	this.dojoServ = dojo;
    }
	@RequestMapping("/new")
	public String newNinja(@ModelAttribute("createNinja") Ninja ninja,Model model) {
		model.addAttribute("dojos", dojoServ.alldojos());
		return "ninjas/new";
	}
	
	@PostMapping("/newNinja")
	public String createNinja(@Valid @ModelAttribute("createNinja") Ninja ninja,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("in ninja eror");
			System.out.println(result);
			return "ninjas/new";
		}else {
		Ninja ninj = ninjaServ.createNinjas(ninja);
		String dojoid = Long.toString(ninj.getDojo().getID());
		System.out.println(dojoid);
			System.out.println("in create ninja");
			return "redirect:/dojos/".concat(dojoid);
		}
		
	}
	

}
