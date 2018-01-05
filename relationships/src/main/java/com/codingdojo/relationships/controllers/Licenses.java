package com.codingdojo.relationships.controllers;

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

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.services.DMVService;



@Controller
@RequestMapping("/license")
public class Licenses {
	private final DMVService dmv;
	
	public Licenses(DMVService dmv) {
		this.dmv = dmv;
		
	}
	
	
	//@InitBinder
	//public void initBinder(WebDataBinder binder) {
	//	System.out.println("in binder");
	//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//	dateFormat.setLenient(false);
	//	System.out.println(dateFormat);
	//	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	//}
	
	
  @RequestMapping("/new")
  public String index(@ModelAttribute("newlicense") License license ,Model model) {
	 // personService.allPeople();
	  model.addAttribute("people", dmv.allPeople());
	  return "/licenses/newLicense";
  }
  @PostMapping("/NewLicense")
  public String createLicense(@Valid @ModelAttribute("newlicense") License license,BindingResult result,Model model) {
	  System.out.println("am in license");
	  if(result.hasErrors()) {
		  System.out.println("in errors");
		  model.addAttribute("people", dmv.allPeople());
		  return "/licenses/newLicense";
	  }else {
		  System.out.println("got to vreate new license");
	    System.out.println(license.getPerson().getFirstName());
	   
	   License lic =  dmv.addLicense(license);
	  // System.out.println(lic.getPerson().getID());
	  // String personId = Long.toString(lic.getPerson().getID());
	  // System.out.println(personId);
	   return "redirect:/persons/new";
	  }
	 
  }
}
