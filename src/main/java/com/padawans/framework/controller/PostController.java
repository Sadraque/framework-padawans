package com.padawans.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.padawans.framework.services.PostService;

@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class PostController {

	@Autowired
	PostService postService;

	@RequestMapping("/posts")
	public String index(Model model) {
		model.addAttribute("texto", "Exemplo de texto com Thymeleaf");
		model.addAttribute("posts", postService.getPosts());

		return "posts.html";
	}
}
