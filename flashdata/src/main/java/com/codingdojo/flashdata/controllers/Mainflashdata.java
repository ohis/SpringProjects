package com.codingdojo.flashdata.controllers;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mainflashdata {

	@RequestMapping("/")
	public String index() {
		System.out.println("got here");
		//System.out.println(errors);
		return "index";
	}
	
	@RequestMapping(path="/code", method=RequestMethod.POST)
	public String displayCode() {
		//if(Code.equals("bushido")) {
			return "display";
		//}
		//System.out.println("entered ");
		//return "redirect:/errors";
	}
	
	// @RequestMapping("/errors")
	//    public String Errors(RedirectAttributes redirectAttributes){
	 //       redirectAttributes.addFlashAttribute("errors", "You must train harder");
	     //   return "redirect:/";
	 //   }
}
