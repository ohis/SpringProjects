package com.codingdojo.learningplatform.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainLP {
	
	@RequestMapping("/")
	public String index() {
		return "Dasboard";
	}
	@RequestMapping("/m/{chapter}/0483/{assignmentNum}")
	public String assignment(@PathVariable String chapter, String assignmentNum,Model model) {
		model.addAttribute("msgA", "The goal of this assignment is to...");
		return "Assignment";
	}
	
	@RequestMapping("/m/{chapter}/0553/{lessonNum}")
	public String lesson(@PathVariable("chapter") String chapter, @PathVariable("lessonNum") String lesson, Model model) {
		model.addAttribute("msgL", "Fortran Advanced Intro placeholder");
		return "Lesson";
	}

}
