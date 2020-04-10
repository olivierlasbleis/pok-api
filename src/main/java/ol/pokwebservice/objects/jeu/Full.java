package ol.pokwebservice.objects.jeu;

import java.util.ArrayList;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Full extends Combinaison{
	
	public Full(List<Carte> listeCartes){
		super(ValeurCombinaison.FULL,
				AllUtils.getFromTo(listeCartes, 0, 4),
				new ArrayList<Carte>(),
				"Full aux " + listeCartes.get(0).getValeurCarte() 
				+ " par les " + listeCartes.get(3).getValeurCarte() 
				);
	}

}
