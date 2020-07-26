package com.filpatterson.demo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * 	Adding initbinder for convering trim input strings, remove leading and trailing
	 * whitespaces, resolve some base issues of validation
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	//	@valid checks validation test of the model and sets result in binding result
	//	@modelAttribute connects result of customer form from html page with customer object in java
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		
		System.out.println("BindingResult: " + bindingResult);
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
