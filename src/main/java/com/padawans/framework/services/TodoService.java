package com.padawans.framework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.padawans.framework.components.ApiWebClient;
import com.padawans.framework.model.Todo;

@Service
public class TodoService {

	@Autowired
	ApiWebClient apiWebClient;

	public List<Todo> getTodos() {
		List<Todo> todos = apiWebClient.getTodos().collectList().block();

		return todos;
	}

}
