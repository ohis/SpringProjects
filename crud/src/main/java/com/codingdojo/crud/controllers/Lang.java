package com.codingdojo.crud.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.crud.models.Langs;

import com.codingdojo.crud.service.LangService;

import org.springframework.validation.BindingResult;
@Controller
public class Lang {
	private  final LangService language;
	public Lang(LangService language) {
		this.language = language;
	}
	@RequestMapping("/lang")
	public String index(@ModelAttribute("lang") Langs lang,Model model) {
		model.addAttribute("langs", language.allLangs());
		return "dashboard";
	}
   @RequestMapping("/")
   public String dashboard(@ModelAttribute("lang") Langs lang, Model model) {
	   //ArrayList<Langs> langs = language.allLangs();
	   System.out.println("in dash"+lang.getName());
	   model.addAttribute("langs",language.allLangs());
	   return "dashboard";
   }
   
   @PostMapping("/lang")
   public String createLang(@Valid @ModelAttribute("lang") Langs lang,BindingResult result,Model model) {
	   System.out.println("inpostmapping");
	   System.out.println(result);
	   if(result.hasErrors()) {
		   System.out.println("in errors");
		   model.addAttribute("langs",language.allLangs());
		   return "dashboard";
	   }else {
		   language.addLang(lang);
		   System.out.println(lang.getName()+" This is the name");
		   return "redirect:/";
	   }
	 
   }
   
   @RequestMapping("/lang/show/{id}")
   public String showLang(Model model, @PathVariable("id") int id) {
	   Langs lang = language.getlanguage(id);
	   model.addAttribute("lang",lang);
	   System.out.println("in display ");
	   return "display";
   }
   
  @RequestMapping("/lang/edit/{id}")
  public String Edit(@ModelAttribute("editLang") Langs l,@PathVariable("id") int id,Model model) {
	  Langs lang = language.getlanguage(id);
	  System.out.println("got to  edit ");
	  model.addAttribute("lang", lang);
	  return "edit";
  }
  @RequestMapping("/lang/delete/{id}")
  public String DelLang(@PathVariable("id") int id) {
	  language.delLang(id);
	  return "redirect:/";
  }
  
  @PostMapping("/lang/edit/{id}")
  public String EditLanguage(@Valid @PathVariable("id") int id, @ModelAttribute("editLang") Langs lang, BindingResult result,Model model) {
	  if(result.hasErrors()) {
		  System.out.println(" edit errors");
		  System.out.println(result);
		  return "redirect:/lang/edit{id}";
	  }else {
		  language.updateLang(id,lang);
		  System.out.println("in edit post ");
	  return "redirect:/lang";
	  }
  }
}
