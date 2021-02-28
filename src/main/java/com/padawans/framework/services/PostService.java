package com.padawans.framework.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.padawans.framework.components.ApiWebClient;
import com.padawans.framework.model.Post;

@Service
public class PostService {

	@Autowired
	ApiWebClient apiWebClient;

	public List<Post> getPosts() {
		List<Post> posts = apiWebClient.getPosts().collectList().block();

		return posts;
	}

}
