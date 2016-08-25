package com.example.webservice.rest;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestAuthController {

	/**
	 * 认证成功返回token
	 * @param session
	 * @return
	 */
	@PostMapping(value="token")
	String authSucc(HttpSession session) {
		return "";
	}
	
}
