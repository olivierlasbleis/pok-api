package ol.pokwebservice.objects.jeu;

import java.util.ArrayList;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Couleur extends Combinaison{
	
	public Couleur(List<Carte> listeCartes){
		super(ValeurCombinaison.COULEUR,
				AllUtils.getFromTo(listeCartes, 0, 4),
				new ArrayList<Carte>(),
				"Couleur de " + listeCartes.get(0).getSigneCarte() 
				);
	}

}
