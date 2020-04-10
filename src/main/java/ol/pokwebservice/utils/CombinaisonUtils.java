package ol.pokwebservice.utils;

import java.util.List;
import java.util.stream.Stream;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Combinaison;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.objects.jeu.Brelan;
import ol.pokwebservice.objects.jeu.Carre;
import ol.pokwebservice.objects.jeu.Couleur;
import ol.pokwebservice.objects.jeu.DoublePaire;
import ol.pokwebservice.objects.jeu.Flush;
import ol.pokwebservice.objects.jeu.Full;
import ol.pokwebservice.objects.jeu.Hauteur;
import ol.pokwebservice.objects.jeu.Paire;
import ol.pokwebservice.objects.jeu.Suite;

public class CombinaisonUtils {
	
	public static Combinaison determinerCombinaisonMaxAvec7Cartes(List<Carte> listeCartes) {
		Combinaison combinaisonMax = null;
		List<List<Carte>> combinaisonsDe5CartesPossibles = AllUtils.getIterations(listeCartes, 7, 5);
		for (List<Carte>  cartes: combinaisonsDe5CartesPossibles) {
			Combinaison combinaison = CombinaisonUtils.determinerCombinaisonMax(cartes);
			if (combinaison.compareTo(combinaisonMax) > 0) {
				combinaisonMax = combinaison;
			}
			
		}
		return combinaisonMax;
	}
	
	public static Combinaison determinerCombinaisonMax(List<Carte> listeCartes) {
		
		listeCartes = CartesUtils.trierCartesParValeur(listeCartes);
		Combinaison combinaison = new Hauteur(listeCartes);
		
		if (determinerSiSuite(listeCartes)) {
			// LE JOUEUR OBTIENT AU MINIMUM UNE SUITE
			combinaison =  new Suite(listeCartes);
		}
				
		if (determinerSiCouleur(listeCartes)){
			// LE JOUEUR OBTIENT AU MINIMUM UNE COULEUR
			if (combinaison.getValeurCombinaison() == ValeurCombinaison.SUITE) {
				// LE JOUEUR OBTIENT UN FLUSH
				combinaison =  new Flush(listeCartes);
			}else {
				combinaison = new Couleur(listeCartes);
			}
		}
		List<Carte> listeOccurences = CartesUtils.obtenirOccurenceMax(listeCartes);
				
		if (listeOccurences.size() == 4) {
			// LE JOUEUR OBTIENT UN CARRE
			List<Carte> cartesRestantes = CartesUtils.supprimerCartes(listeCartes, listeOccurences);
			listeOccurences.add(cartesRestantes.get(0));
			combinaison = new Carre(listeOccurences);
		}else if (listeOccurences.size() == 3) {
			// LE JOUEUR OBTIENT AU MINIMUM UN BRELAN
			List<Carte> cartesRestantes = CartesUtils.supprimerCartes(listeCartes, listeOccurences);
			if (CartesUtils.obtenirOccurenceMax(cartesRestantes).size() == 2) {
				// LE JOUEUR OBTIENT UN FULL
				listeOccurences.addAll(cartesRestantes);
				combinaison = new Full(listeOccurences);
			}else if (combinaison.getValeurCombinaison() == ValeurCombinaison.HAUTEUR) {
				listeOccurences.addAll(cartesRestantes);
				combinaison = new Brelan(listeOccurences);
			}
		}else if (listeOccurences.size() == 2) {
			// LE JOUEUR OBTIENT AU MINIMUM UNE PAIRE
			List<Carte> cartesRestantes = CartesUtils.supprimerCartes(listeCartes, listeOccurences);
			if (combinaison.getValeurCombinaison() == ValeurCombinaison.HAUTEUR
			&& CartesUtils.obtenirOccurenceMax(cartesRestantes).size() == 2) {
				// LE JOUEUR OBTIENT UNE DOUBLE PAIRE
				List<Carte> deuxiemePaire = CartesUtils.obtenirOccurenceMax(cartesRestantes);
				cartesRestantes = CartesUtils.supprimerCartes(cartesRestantes, deuxiemePaire);
				listeOccurences.addAll(deuxiemePaire);
				listeOccurences.addAll(cartesRestantes);
				combinaison = new DoublePaire(listeOccurences);
			}else if (combinaison.getValeurCombinaison() == ValeurCombinaison.HAUTEUR){
				listeOccurences.addAll(cartesRestantes);
				combinaison = new Paire(listeOccurences);
			}
		
			
		}
		
		
		return combinaison;
	}
	
	public static boolean determinerSiCouleur(List<Carte> listeCartes) {
		Stream streamCartes = listeCartes.stream();
		SigneCarte signeCouleur = listeCartes.get(0).getSigneCarte();
		boolean couleur = streamCartes.allMatch(carte -> ((Carte) carte).getSigneCarte() == signeCouleur);
		return couleur;
	}
	
	public static boolean determinerSiSuite(List<Carte> listeCartes) {
		boolean suite = true;
		int indexDepart = 1;
		if (listeCartes.get(0).getValeurCarte() == ValeurCarte.DEUX 
				&& listeCartes.get(4).getValeurCarte() == ValeurCarte.AS) {
			
			listeCartes = AllUtils.getFromTo(listeCartes, 0, 3);
		}
		
		for ( int i = indexDepart ; i < listeCartes.size(); i++) {
			if (listeCartes.get(i).getValeurCarte().compareTo(listeCartes.get(i - 1).getValeurCarte()) != 1) {
				suite = false;
			}
		}
		
		return suite;
	}
	
	

}
