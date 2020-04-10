package ol.pokwebservice.objects.jeu;

import java.util.ArrayList;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Flush extends Combinaison{
	
	public Flush(List<Carte> listeCartes){
		super(ValeurCombinaison.FLUSH,
				AllUtils.getFromTo(listeCartes, 0, 4),
				new ArrayList<Carte>(),
				"Flush hauteur " + listeCartes.get(4).getValeurCarte() 
				+ " par les " + listeCartes.get(0).getSigneCarte() 
				);
	}

}
