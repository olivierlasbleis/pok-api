package ol.pokwebservice.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Main;
import ol.pokwebservice.objects.Prevision;
import ol.pokwebservice.objects.Resolution;
import ol.pokwebservice.objects.vues.CarteVue;
import ol.pokwebservice.objects.vues.PrevisionVue;
import ol.pokwebservice.services.ApiAccountService;
import ol.pokwebservice.services.CarteService;
import ol.pokwebservice.services.PrevisionService;
import ol.pokwebservice.services.ResolutionService;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;

@RestController
public class PrevisionController {
	
	@Autowired
	ResolutionService resolutionService;
	
	@Autowired
	PrevisionService previsionService;
	
	@Autowired
	CarteService carteService;
	
	@Autowired
	ApiAccountService apiAccountService;
	
	
	
	@GetMapping("/getPrevision/{carte1}/{carte2}/{carte3}/{carte4}/{carte5}/{carte6}/{carte7}")
	public PrevisionVue obtenirPrevision(@PathVariable(value="carte1") String carte1,
			@PathVariable(value="carte2") String carte2,
			@PathVariable(value="carte3") String carte3,
			@PathVariable(value="carte4") String carte4,
			@PathVariable(value="carte5") String carte5,
			@PathVariable(value="carte6") String carte6,
			@PathVariable(value="carte7") String carte7) {
		if (carte6.equals("null")) {
			carte6 = null;
		}
		if (carte7.equals("null")) {
			carte7 = null;
		}
		
		Main mainJoueur = new Main(carteService.findOrSave(CartesUtils.instancierCarte(carte1)),
				carteService.findOrSave(CartesUtils.instancierCarte(carte2)));
		
		List<Carte> cartesFlop = new ArrayList<Carte>();
		if (carte3 != null) {
			cartesFlop.add(CartesUtils.instancierCarte(carte3));
			cartesFlop.add(CartesUtils.instancierCarte(carte4));
			cartesFlop.add(CartesUtils.instancierCarte(carte5));
		}
		if (carte6 != null) {
			cartesFlop.add(CartesUtils.instancierCarte(carte6));
		}
		if (carte7 != null) {
			cartesFlop.add(CartesUtils.instancierCarte(carte7));
		}
		
		
		int n = 0;
		for (Carte carte : cartesFlop) {
				cartesFlop.set(n, carteService.findOrSave(carte));
				n++;
		}
		double pourcentageGagne = 0.0;
		double[][] rangePrevision = new double[13][13];
		List<Carte> cartesDejaVisible = new ArrayList<Carte>(cartesFlop);
		cartesDejaVisible.add(mainJoueur.getCarte1());
		cartesDejaVisible.add(mainJoueur.getCarte2());
		List<Carte> cartes = cartesDejaVisible;
		List<Carte> paquetCarte = carteService.getPaquetCarte(cartesDejaVisible);
		List<Resolution> listeResolutions = new ArrayList<>();
		if (cartesFlop.size() == 3) {
			for (Carte carte1_ : paquetCarte) {
				paquetCarte = carteService.getPaquetCarte(cartesDejaVisible);
				paquetCarte = CartesUtils.supprimerCartes(paquetCarte, Arrays.asList(carte1_));
				for (Carte carte2_ : paquetCarte) {
					if (AllUtils.getRandomNumberInRange(0, 50)==0) {
						List<Carte> cartesFlopFinal = new ArrayList<Carte>(cartesFlop);
						cartesFlopFinal.add(carte1_);
						cartesFlopFinal.add(carte2_);
						//long startTime = System.currentTimeMillis();
						listeResolutions.add(resolutionService.newResolution(mainJoueur, cartesFlopFinal));
						//long exTime = System.currentTimeMillis() - startTime;
						//System.out.println(exTime);
					}
					
				}
			}
		}else if (cartesFlop.size() == 4) {
			for (Carte carte : paquetCarte) {
				
					List<Carte> cartesFlopFinal = new ArrayList<Carte>(cartesFlop);
					cartesFlopFinal.add(carte);
					//long startTime = System.currentTimeMillis();
					listeResolutions.add(resolutionService.newResolution(mainJoueur, cartesFlopFinal));
					//long exTime = System.currentTimeMillis() - startTime;
					//System.out.println(exTime);
				
			}
		}else if (cartesFlop.size() == 5){
			List<Carte> cartesFlopFinal = new ArrayList<Carte>(cartesFlop);
			listeResolutions.add(resolutionService.newResolution(mainJoueur, cartesFlopFinal));
		}
		
		List<Resolution> resolutions = listeResolutions;
		for (Resolution resolution : listeResolutions) {
			pourcentageGagne = pourcentageGagne + resolution.getPourcentageGagne();
			for (int i = 0; i < rangePrevision.length; i++) {
				for (int j = 0; j < rangePrevision[i].length; j++) {
					if (Double.isNaN(resolution.getRangeResolution()[i][j])) {
						rangePrevision[i][j] = rangePrevision[i][j];
					}else {
						rangePrevision[i][j] = rangePrevision[i][j] + resolution.getRangeResolution()[i][j];
					}
				}
			}
			
		}
		for (int i = 0; i < rangePrevision.length; i++) {
			for (int j = 0; j < rangePrevision[i].length; j++) {
				rangePrevision[i][j] = rangePrevision[i][j] / listeResolutions.size();
			}
		}
		pourcentageGagne  = pourcentageGagne / listeResolutions.size();
		
		Prevision prevision = new Prevision(cartes,
				resolutions,
				rangePrevision,
				pourcentageGagne);
		return previsionService.convertPrevisionToPrevisionVue(prevision);
		
	}
	

}
