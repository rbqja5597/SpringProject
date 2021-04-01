package com.example.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	
	
	// http://localhost:8023/usr/home/main
	@RequestMapping("usr/home/main")
	@ResponseBody
	public String ShowMain() {
		return "라이브";
	}
}
