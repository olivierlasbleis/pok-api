package ol.pokwebservice.objects.vues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.Joueur;


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

	public JoueurVue(String nomJoueur, double pourcentageFlop, double pourcentageTurn, double pourcentageRiver,
			double pourcentageShowDown) {
		super();
		this.nomJoueur = nomJoueur;
		this.pourcentageFlop = pourcentageFlop;
		this.pourcentageTurn = pourcentageTurn;
		this.pourcentageRiver = pourcentageRiver;
		this.pourcentageShowDown = pourcentageShowDown;
	}

	public JoueurVue() {
		super();
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public double getPourcentageFlop() {
		return pourcentageFlop;
	}

	public void setPourcentageFlop(double pourcentageFlop) {
		this.pourcentageFlop = pourcentageFlop;
	}

	public double getPourcentageTurn() {
		return pourcentageTurn;
	}

	public void setPourcentageTurn(double pourcentageTurn) {
		this.pourcentageTurn = pourcentageTurn;
	}

	public double getPourcentageRiver() {
		return pourcentageRiver;
	}

	public void setPourcentageRiver(double pourcentageRiver) {
		this.pourcentageRiver = pourcentageRiver;
	}

	public double getPourcentageShowDown() {
		return pourcentageShowDown;
	}

	public void setPourcentageShowDown(double pourcentageShowDown) {
		this.pourcentageShowDown = pourcentageShowDown;
	}
	
}
