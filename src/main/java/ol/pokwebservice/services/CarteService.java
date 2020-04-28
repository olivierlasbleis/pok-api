package ol.pokwebservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Main;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.objects.vues.CarteVue;
import ol.pokwebservice.repositories.CarteRepository;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;

@Service
public class CarteService {
	@Autowired
	public CarteRepository carteRepository;
	
	public List<Main> getMainsPossibles(List<Carte> cartesDejaVisibles){
		List<Carte> paquetDeCarte = getPaquetCarte(cartesDejaVisibles);
		List<int[]> combinaisonPossibles = AllUtils.genererTableauxIterations(paquetDeCarte.size(), 2);
		List<Main> listeMainsPossibles = new ArrayList<Main>();
		
		for (int[] combinaison : combinaisonPossibles) {
			listeMainsPossibles.add(new Main(paquetDeCarte.get(combinaison[0]),paquetDeCarte.get(combinaison[1])));
		}
		return listeMainsPossibles;
	}
	
	public List<Carte> getPaquetCarte(List<Carte> cartesDejaVisible) {
		List<Carte> paquetCarte = new ArrayList<>();
		for (SigneCarte signeCarte : SigneCarte.values()) {
			for (ValeurCarte valeurCarte : ValeurCarte.values()) {
				paquetCarte.add(findOrSave(new Carte(valeurCarte, signeCarte)));
			}
		}
		return CartesUtils.supprimerCartes(paquetCarte, cartesDejaVisible);
	}
	
	public  Carte findOrSave(Carte carte) {
		List<Carte> carteOpt = carteRepository.findByValeurCarteAndSigneCarte(
						carte.getValeurCarte(), 
						carte.getSigneCarte());
		if (carteOpt.size()>0) {
			return carteOpt.get(0);
		}else {
			return carteRepository.save(carte);
		}
	}

	


}
