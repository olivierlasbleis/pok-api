package ol.pokwebservice.objects.jeu;

import java.util.Arrays;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.CartesUtils;

public class Hauteur extends Combinaison{
	
	public Hauteur(List<Carte> listeCartes) {
		super(ValeurCombinaison.HAUTEUR,
				Arrays.asList(listeCartes.get(4)),
				CartesUtils.supprimerCartes(listeCartes, Arrays.asList(listeCartes.get(4))),
						"Hauteur ");
	}

}
