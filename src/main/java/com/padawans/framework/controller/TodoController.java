package com.padawans.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padawans.framework.model.Todo;
import com.padawans.framework.services.TodoService;


@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	private final int pageNumber = 5;
	private int pageSize;

	@RequestMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("todos", todoService.getTodos());
		model.addAttribute("todosNumber", todoService.getTodos().size());
		model.addAttribute("path", "http://localhost:8080/todos/");

		return "todos.html";
	}
	
	@RequestMapping("/todos/{page}")
	public String todosByPage(Model model, @PathVariable("page") int pagina) {
		pageSize = todoService.getTodos().size() / pageNumber;
		
		int fromIndex = (pagina * pageSize) - pageSize; 
		int toIndex = fromIndex + (pageSize);
		
		List<Todo> todos = todoService.getTodos().subList(fromIndex, toIndex);

		model.addAttribute("todos", todos);
		model.addAttribute("todosNumber", todoService.getTodos().size());
		model.addAttribute("path", "http://localhost:8080/todos/");

		return "todos.html";
	}
}
