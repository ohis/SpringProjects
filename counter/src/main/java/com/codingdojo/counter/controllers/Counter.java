package com.codingdojo.counter.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpSession;
@Controller
@SessionAttributes("sessionAttribute")
public class Counter {
  // int count = 10;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count",0);
		}else {
			Integer currentCount = count + 1;
			System.out.println("in count not  equl null "+ currentCount);
			session.setAttribute("count", currentCount);
		}
		return "index";
	}
     @RequestMapping("/counter")
     public String displayCount() {
    	 return "counter";
     }
}
