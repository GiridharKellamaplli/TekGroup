package com.tektimesheetsui.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterviewUIController {

	@RequestMapping(value="/viewPage",method=RequestMethod.GET)
	public String homePage(){
		System.out.println("hello");
		return "index";
	}
	
}
