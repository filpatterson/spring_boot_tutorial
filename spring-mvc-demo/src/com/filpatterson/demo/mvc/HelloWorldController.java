package com.filpatterson.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//	controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld_form";
	}
	
	//	controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//	controller method with request handling using annotation requestParam
	@RequestMapping("/processFormV2")
	public String uppercaseTransform(@RequestParam("studentName") String name, 
			Model model) {		
		//	convert to upper-case
		name = name.toUpperCase();
		
		//	add some object to the model with name "message" and value result
		model.addAttribute("message", name);

		return "helloworld";
	}
}
