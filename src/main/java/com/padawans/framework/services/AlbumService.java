package com.padawans.framework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.padawans.framework.components.ApiWebClient;
import com.padawans.framework.model.Album;

@Service
public class AlbumService {

	@Autowired
	ApiWebClient apiWebClient;

	public List<Album> getAlbums() {
		List<Album> albums = apiWebClient.getAlbums().collectList().block();

		return albums;
	}

}
