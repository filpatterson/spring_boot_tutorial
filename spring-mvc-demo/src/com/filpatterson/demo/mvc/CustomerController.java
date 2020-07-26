package com.filpatterson.demo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//	@valid checks validation test of the model and sets result in binding result
	//	@modelAttribute connects result of customer form from html page with customer object in java
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}
	
	//	object is connected with model via setting attribute with name and value
	@RequestMapping("/showForm")
	public String showForm(Model model) {	
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
}
