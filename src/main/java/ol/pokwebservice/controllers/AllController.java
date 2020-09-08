package ol.pokwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ol.pokwebservice.services.AllService;

@RestController
public class AllController {

	@Autowired
	AllService allService;
	
	@GetMapping("/echelle")
	public String[] getColorEchelle() {
		return allService.getListColorEchelle();
	}
}
