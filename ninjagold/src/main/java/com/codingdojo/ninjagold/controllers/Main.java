package com.codingdojo.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
  protected int farmVal;
  String ninja;
  int result;
  int caveVal;
  int houseVal;
  int sum = 0;
  int casinoVal;
  ArrayList<String> messages = new ArrayList<String>();
  Random rand = new Random();
	 @RequestMapping("/")
	 public String index(Model model) {
		 sum+=result;
		 model.addAttribute("result", sum);
		 model.addAttribute("ninja", ninja);
		 model.addAttribute("msg", messages);
		 return "index";
	 }
	 
	 @RequestMapping(path="/farm" ,method=RequestMethod.POST)
	 public String farm(@RequestParam(value="farm") String farm, Model model) {
		farmVal = rand.nextInt((20 - 10) + 1) + 10;
		result = farmVal;
		ninja = farm;
		Date d = new Date();
		
		String date = String.format("%tB  %<te  %<tY %<tr", d);
		String m = Integer.toString(result);
		messages.add("You entered a farm and have earned " + m + " gold " + date);
		System.out.println(farm);
		System.out.println(result);
		 return "redirect:/";
	 }
	 
	 @RequestMapping(path="/cave" ,method=RequestMethod.POST)
	 public String cave(@RequestParam(value="cave") String cave) {
		caveVal = rand.nextInt((10 - 5) + 1) + 5;
		result = caveVal;
		ninja = cave;
		String m = Integer.toString(result);
        Date d = new Date();
		
		String date = String.format("%tB  %<te  %<tY %<tr", d);
		messages.add("You have entered a cave and just earned " + m +" gold "+date);
		System.out.println(result);
		 return "redirect:/";
	 }
	 
	 @RequestMapping(path="/house" ,method=RequestMethod.POST)
	 public String house(@RequestParam(value="house") String house) {
		houseVal = rand.nextInt((5 - 2) + 1) + 2;
		result = houseVal;
		ninja = house;
		Date d = new Date();
		
		String date = String.format("%tB  %<te  %<tY %<tr", d);
		String m = Integer.toString(result);
		messages.add("You have entered a house and just earned "+ m+" gold "+ date);
		System.out.println(result);
		 return "redirect:/";
	 }
	 
	 @RequestMapping(path="/casino" ,method=RequestMethod.POST)
	 public String result(@RequestParam(value="casino") String casino) {
		casinoVal = rand.nextInt(101) - 50;
		result = casinoVal;
		String m = Integer.toString(result);
		Date d = new Date();
		String date = String.format("%tB  %<te  %<tY %<tr", d);
		if(result < 0) {
			messages.add("You entered a  casino and just lost "+m + " gold "+"..ouch " +date);
		}else {
			messages.add("You entered a casino and just earned "+m+" gold "+ date);
		}
		ninja = casino;
		System.out.println(result);
		 return "redirect:/";
	 }
	 
}
