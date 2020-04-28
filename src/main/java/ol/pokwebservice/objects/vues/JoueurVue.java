package ol.pokwebservice.objects.vues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.Joueur;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurVue {

	private String nomJoueur;
	private double pourcentageFlop;
	private double pourcentageTurn;
	private double pourcentageRiver;
	private double pourcentageShowDown;
	
	public JoueurVue(Joueur joueur) {
		this.nomJoueur = joueur.getNomJoueur();
		this.pourcentageFlop = joueur.getNbFlop() * 1.0 / joueur.getNbPreflop();
		this.pourcentageTurn = joueur.getNbTurn() * 1.0 / joueur.getNbPreflop();
		this.pourcentageRiver = joueur.getNbRiver() * 1.0 / joueur.getNbPreflop();
		this.pourcentageShowDown = joueur.getNbShowDown() * 1.0 / joueur.getNbPreflop();
	}
	
}
