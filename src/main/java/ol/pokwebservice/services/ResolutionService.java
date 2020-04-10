package ol.pokwebservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Main;
import ol.pokwebservice.objects.Resolution;
import ol.pokwebservice.repositories.ResolutionRepository;
import ol.pokwebservice.utils.CartesUtils;
import ol.pokwebservice.utils.MainsUtils;

@Service
public class ResolutionService {
	
	@Autowired
	ResolutionRepository resolutionRepository;
	
	@Autowired
	CarteService carteService;
	
	
	public void save(Resolution resolution) {
		resolutionRepository.save(resolution);
	}

	public Resolution newResolution(Main mainJoueur, List<Carte> cartesFlopFinal) {
		
		
		List<Carte> cartesFlopJoueur  = new ArrayList<Carte>(cartesFlopFinal);
		cartesFlopJoueur.add(mainJoueur.getCarte1());
		cartesFlopJoueur.add(mainJoueur.getCarte2());
		cartesFlopJoueur = CartesUtils.trierCartesParValeur(cartesFlopJoueur);
		
		List<Resolution> resolutionOpt = resolutionRepository.findByCartes(
				cartesFlopJoueur.get(0), 
				cartesFlopJoueur.get(1),
				cartesFlopJoueur.get(2), 
				cartesFlopJoueur.get(3),
				cartesFlopJoueur.get(4), 
				cartesFlopJoueur.get(5),
				cartesFlopJoueur.get(6));
		if (resolutionOpt.size()>0) {
			return resolutionOpt.get(0);
		}else {
			List<Main> mainsAdversairePossibles = carteService.getMainsPossibles(cartesFlopJoueur);
			
			return resolutionRepository.save(new Resolution(mainJoueur, cartesFlopFinal, mainsAdversairePossibles));
		}

		
	}
			

}
