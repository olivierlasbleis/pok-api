package ol.pokwebservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ol.pokwebservice.objects.ApiAccount;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.vues.CarteVue;
import ol.pokwebservice.services.ApiAccountService;
import ol.pokwebservice.services.CarteService;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;

@RestController
public class CarteController {
	
	@Autowired
	CarteService carteService;
	
	@Autowired
	ApiAccountService apiAccountService;

	@GetMapping("/getPaquetCarte")
	public List<CarteVue> getApiKey() {
		Stream stream = carteService.getPaquetCarte(new ArrayList<Carte>()).stream();
		return (List<CarteVue>) stream.map(carte -> ((Carte) carte).instancierCarteVue()).collect(Collectors.toList());
	}
	
	@PostMapping(path = "/postCards", consumes = "application/json", produces = "application/json")
	public List<CarteVue> postCards(@RequestParam String apiKey , @RequestBody List<CarteVue> cartesVues) {
		if (apiAccountService.newCallApi(apiKey)) {
			List<Carte> cartes = (List<Carte>) cartesVues.stream().map(carteVue -> carteService.findOrSave(CartesUtils.instancierCarte(carteVue.getNomCarte()))).collect(Collectors.toList());
			return apiAccountService.saveListCards(apiKey , cartes).stream().map(carte -> carte.instancierCarteVue()).collect(Collectors.toList());
		}else {
			return null;
		}
		
		}
	
}
