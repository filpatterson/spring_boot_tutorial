package com.filpatterson.demo.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class HomeController {
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
