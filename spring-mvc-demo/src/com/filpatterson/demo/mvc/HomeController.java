package com.filpatterson.demo.mvc;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPage(HttpServletResponse httpResponse) {
		return "main-menu";
	}
}
