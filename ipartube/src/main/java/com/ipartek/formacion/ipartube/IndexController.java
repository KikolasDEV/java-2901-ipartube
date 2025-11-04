package com.ipartek.formacion.ipartube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("videos", anonimoService.listadoVideos());
		return "listado";
	}
	
	@GetMapping("video/{id}")
	public String video(Long id, Model modelo) {
		modelo.addAttribute("video", anonimoService.detalleVideo(id));
		
		return "video";
	}
}
