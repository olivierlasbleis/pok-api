package ol.pokwebservice.objects.jeu;

import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.AllUtils;

public class DoublePaire extends Combinaison{
	
	public DoublePaire(List<Carte> listeCartes){
		super(ValeurCombinaison.DOUBLE_PAIRE,
				AllUtils.getFromTo(listeCartes, 0, 3),
				AllUtils.getFromTo(listeCartes, 4, 4),
				"Doublle Paire " + listeCartes.get(0).getValeurCarte() 
				+ " par les " + listeCartes.get(2).getValeurCarte());
	}

}
