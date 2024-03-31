package com.example.LoveBridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/lb")
public class Test {
	
	@GetMapping("/main")
	public String test() {
		return "/main/main";
	}
	
}