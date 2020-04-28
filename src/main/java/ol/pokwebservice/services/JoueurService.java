package ol.pokwebservice.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.ApiAccount;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Joueur;
import ol.pokwebservice.objects.vues.CarteVue;
import ol.pokwebservice.objects.vues.JoueurPostVue;
import ol.pokwebservice.objects.vues.JoueurVue;
import ol.pokwebservice.repositories.JoueurRepository;

@Service
public class JoueurService {
	
	@Autowired
	JoueurRepository joueurRepository;
	
	public  Joueur findOrSave(JoueurPostVue joueurVue) {
		List<Joueur> joueurOpt = joueurRepository.findByNomJoueur(
				joueurVue.getNomJoueur());
		if (joueurOpt.size()>0) {
			Joueur joueur = joueurOpt.get(0);
			joueur.incrementerEtape(joueurVue.getEtape());
			return joueur;
		}else {
			return joueurRepository.save(joueurVue.transFormToJoueur());
		}
	}

	public List<JoueurVue> saveListJoueurs(List<Joueur> joueurs) {
		List<JoueurVue> listeJoueurVues = new ArrayList<JoueurVue>();
		
		for (Joueur joueur : joueurs) {
			listeJoueurVues.add(transFormToJoueurVue(joueurRepository.save(joueur)));
		}
		return listeJoueurVues;
	}
	
	public JoueurVue transFormToJoueurVue(Joueur joueur) {
		return new JoueurVue(joueur);
	}

}
