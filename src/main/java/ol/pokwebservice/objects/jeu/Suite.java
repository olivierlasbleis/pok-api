package ol.pokwebservice.objects.jeu;

import java.util.ArrayList;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class Suite extends Combinaison{
	
	public Suite(List<Carte> listeCartes){
		super(ValeurCombinaison.SUITE,
				AllUtils.getFromTo(listeCartes, 0, 4),
				new ArrayList<Carte>(),
				"Suite hauteur " + listeCartes.get(4).getValeurCarte()  
				);
	}

}
