package com.padawans.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.padawans.framework.services.TodoService;


@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("todos", todoService.getTodos());

		return "todos.html";
	}
}
