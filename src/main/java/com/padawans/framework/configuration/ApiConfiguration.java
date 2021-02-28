package com.padawans.framework.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:application.properties")
@Getter @Setter
public class ApiConfiguration {

	@Value("${api.resource.baseUrl}")
	public String apiBaseUrl;

	@Value("${api.resource.albuns}")
	public String apiAlbums;

	@Value("${api.resource.posts}")
	public String apiPosts;

	@Value("${api.resource.todos}")
	public String apiTodos;
}