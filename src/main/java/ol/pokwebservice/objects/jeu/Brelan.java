package ol.pokwebservice.objects.jeu;

import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Brelan extends Combinaison{
	
	public Brelan(List<Carte> listeCartes){
		super(ValeurCombinaison.BRELAN,
				AllUtils.getFromTo(listeCartes, 0, 2),
				AllUtils.getFromTo(listeCartes, 3, 4),
				"Bralan de " + listeCartes.get(0).getValeurCarte() 
				);
	}

}
