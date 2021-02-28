package com.padawans.framework.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class IndexController {

	@RequestMapping("/")
	public String index() {

		return "index.html";
	}
}
