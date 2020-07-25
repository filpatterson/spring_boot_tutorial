package com.filpatterson.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funny")
public class FunnyController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}
}
