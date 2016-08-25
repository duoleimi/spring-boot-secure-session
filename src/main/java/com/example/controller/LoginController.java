package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class LoginController {
	
	
	@RequestMapping(method = RequestMethod.GET, value="loginp")
	public String loginPage() {
		return "login";
	}
	
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="succ")
	public String succ() {
		return "succ";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String index() {
		return "login";
	}

}
