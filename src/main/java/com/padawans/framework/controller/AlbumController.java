package com.padawans.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padawans.framework.model.Album;
import com.padawans.framework.services.AlbumService;


@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class AlbumController {

	@Autowired
	AlbumService albumService;
	
	private final int pageNumber = 5;
	private int pageSize;

	@RequestMapping("/albums")
	public String albums(Model model) {
		model.addAttribute("albums", albumService.getAlbums());
		model.addAttribute("albumsNumber", albumService.getAlbums().size());
		model.addAttribute("path", "http://localhost:8080/albums/");
		
		return "albums.html";
	}
	
	@RequestMapping("/albums/{page}")
	public String albumsByPage(Model model, @PathVariable("page") int pagina) {
		pageSize = albumService.getAlbums().size() / pageNumber;
		
		int fromIndex = (pagina * pageSize) - pageSize; 
		int toIndex = fromIndex + (pageSize);
		
		List<Album> albums = albumService.getAlbums().subList(fromIndex, toIndex);

		model.addAttribute("albums", albums);
		model.addAttribute("albumsNumber", albumService.getAlbums().size());
		model.addAttribute("path", "http://localhost:8080/albums/");

		return "albums.html";
	}

}