package ol.pokwebservice.objects.jeu;

import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Carre extends Combinaison{
	
	public Carre(List<Carte> listeCartes){
		super(ValeurCombinaison.CARRE,
				AllUtils.getFromTo(listeCartes, 0, 3),
				AllUtils.getFromTo(listeCartes, 4, 4),
				"Carre de " + listeCartes.get(0).getValeurCarte() 
				);
	}

}
