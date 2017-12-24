package com.codingdojo.displaydate.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Dashboard {
	@RequestMapping("/")
	public String dash() {
		return "dashboard";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date d = new Date();
		//SimpleDateFormat f = new SimpleDateFormat("E 'the' dd M yyyy");
		//String date = f.format(d);
		//System.out.println(date);
		String date = String.format("%tA, the %<te of %<tB, %<tY", d);
		model.addAttribute("date",date);
		return "Date";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat(" hh:mm a");
		String time = f.format(d);
		model.addAttribute("time", time);
		return "Time";
	}
	
	
	

}
