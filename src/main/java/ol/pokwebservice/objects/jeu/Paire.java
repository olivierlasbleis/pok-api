package ol.pokwebservice.objects.jeu;

import java.util.Arrays;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.CartesUtils;

public class Paire extends Combinaison{
	
	ValeurCarte valeurPaire;
	ValeurCarte hauteurPaire;
	Carte carte0;
	Carte carte1;
	
	public Paire(List<Carte> listeCartes) {
		super(ValeurCombinaison.PAIRE,
		Arrays.asList(listeCartes.get(0),listeCartes.get(1)),
		CartesUtils.supprimerCartes(listeCartes,Arrays.asList(listeCartes.get(0),listeCartes.get(1))) ,
		"Paire de " + listeCartes.get(0).getValeurCarte() + ", hauteur " + listeCartes.get(4).getValeurCarte());
	}

	

}
