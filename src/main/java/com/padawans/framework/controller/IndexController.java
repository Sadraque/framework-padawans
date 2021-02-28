package com.padawans.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.padawans.framework.services.PostService;

@Controller
public class IndexController {

	@Autowired
	PostService postService;

	@RequestMapping("/")
	public String index() {
		postService.getPosts();

		return "index";
	}
}
