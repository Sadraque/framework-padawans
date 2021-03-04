package com.padawans.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.padawans.framework.model.Post;
import com.padawans.framework.services.PostService;
import lombok.Getter;
import lombok.Setter;

@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
@Getter 
@Setter
public class PostController {

	@Autowired
	PostService postService;

	private final int pageNumber = 5;
	private int pageSize;
	
	@RequestMapping("/posts")
	public String allPosts(Model model) {
		model.addAttribute("pageNumber", postService.getPosts().size() / pageSize);
		model.addAttribute("posts", postService.getPosts());
		model.addAttribute("postsNumber", postService.getPosts().size());
		model.addAttribute("path", "http://localhost:8080/posts/");		

		return "posts.html";
	}
	
	@RequestMapping("/posts/{page}")
	public String postsByPage(Model model, @PathVariable("page") int pagina) {
		pageSize = postService.getPosts().size() / pageNumber;
		
		int fromIndex = (pagina * pageSize) - pageSize; 
		int toIndex = fromIndex + (pageSize);
		
		List<Post> posts = postService.getPosts().subList(fromIndex, toIndex);

		model.addAttribute("posts", posts);
		model.addAttribute("postsNumber", postService.getPosts().size());
		model.addAttribute("path", "http://localhost:8080/posts/");

		return "posts.html";
	}

}