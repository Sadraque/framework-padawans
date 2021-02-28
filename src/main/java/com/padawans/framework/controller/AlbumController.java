package com.padawans.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.padawans.framework.services.AlbumService;


@Controller
@ComponentScan(basePackages = "com.padawans.framework.controller")
public class AlbumController {

	@Autowired
	AlbumService albumService;

	@RequestMapping("/albums")
	public String albums(Model model) {
		model.addAttribute("albums", albumService.getAlbums());

		return "albums.html";
	}
}
