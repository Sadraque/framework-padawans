package com.padawans.framework.components;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.padawans.framework.configuration.ApiConfiguration;
import com.padawans.framework.model.Album;
import com.padawans.framework.model.Post;
import com.padawans.framework.model.Todo;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Flux;

@Component
@Getter
@Setter
public class ApiWebClient {

	private final String postsResource;
	private final String albumsResource;
	private final String todosResource;
	private WebClient webClient;

	public ApiWebClient(WebClient webClient, ApiConfiguration apiConfiguration) {
		this.webClient = webClient;
		this.postsResource = apiConfiguration.getApiPosts();
		this.albumsResource = apiConfiguration.getApiAlbums();
		this.todosResource = apiConfiguration.getApiTodos();
	}

	public Flux<Post> getPosts() {
		Flux<Post> response = webClient.get().uri(postsResource).retrieve().bodyToFlux(Post.class);

		return response;
	}

	public Flux<Album> getAlbums() {
		Flux<Album> response = webClient.get().uri(albumsResource).retrieve().bodyToFlux(Album.class);

		return response;
	}

	public Flux<Todo> getTodos() {
		Flux<Todo> response = webClient.get().uri(todosResource).retrieve().bodyToFlux(Todo.class);

		return response;
	}
}