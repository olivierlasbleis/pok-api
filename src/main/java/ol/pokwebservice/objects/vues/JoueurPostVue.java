package ol.pokwebservice.objects.vues;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.Joueur;
import ol.pokwebservice.objects.enums.Etape;


public class JoueurPostVue {

	private String nomJoueur;
	private Etape etape;
	
	
	public JoueurPostVue(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	public Joueur transFormToJoueur() {
		return new Joueur(this.nomJoueur, this.etape);
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public JoueurPostVue() {
		super();
	}

	public JoueurPostVue(String nomJoueur, Etape etape) {
		super();
		this.nomJoueur = nomJoueur;
		this.etape = etape;
	}
	
}
