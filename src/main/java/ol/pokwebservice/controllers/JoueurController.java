package ol.pokwebservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Joueur;
import ol.pokwebservice.objects.vues.CarteVue;
import ol.pokwebservice.objects.vues.JoueurPostVue;
import ol.pokwebservice.objects.vues.JoueurVue;
import ol.pokwebservice.services.ApiAccountService;
import ol.pokwebservice.services.JoueurService;
import ol.pokwebservice.utils.CartesUtils;

@RestController
public class JoueurController {
	
	@Autowired
	ApiAccountService apiAccountService;
	
	@Autowired
	JoueurService joueurService;

	@PostMapping(path = "/postJoueurs", consumes = "application/json", produces = "application/json")
	public List<JoueurVue> postCards(@RequestParam String apiKey , @RequestBody List<JoueurPostVue> joueurVues) {
		if (apiAccountService.newCallApi(apiKey)) {
			List<Joueur> joueurs = (List<Joueur>) joueurVues.stream().map(joueurVue -> joueurService.findOrSave(joueurVue)).collect(Collectors.toList());
			return joueurService.saveListJoueurs(joueurs);
		}else {
			return null;
		}
		
	}
	
}
