package ol.pokwebservice.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.enums.Etape;
import ol.pokwebservice.objects.vues.JoueurPostVue;
import ol.pokwebservice.objects.vues.JoueurVue;

@Entity
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomJoueur;
	private Integer nbPreflop;
	private Integer nbFlop;
	private Integer nbTurn;
	private Integer nbRiver;
	private Integer nbShowDown;
	
	public Joueur(String nomJoueur, Etape etape) {
		this.nomJoueur = nomJoueur;
		if (etape == Etape.PREFLOP) {
			this.nbPreflop = 1;
			this.nbFlop = 0;
			this.nbTurn = 0;
			this.nbRiver = 0;
			this.nbShowDown = 0;
		}else if(etape == Etape.FLOP){
			this.nbPreflop = 1;
			this.nbFlop = 1;
			this.nbTurn = 0;
			this.nbRiver = 0;
			this.nbShowDown = 0;
		}else if(etape == Etape.TURN){
			this.nbPreflop = 1;
			this.nbFlop = 1;
			this.nbTurn = 1;
			this.nbRiver = 0;
			this.nbShowDown = 0;
		}else if(etape == Etape.RIVER){
			this.nbPreflop = 1;
			this.nbFlop = 1;
			this.nbTurn = 1;
			this.nbRiver = 1;
			this.nbShowDown = 0;
		}else if(etape == Etape.SHOWDOWN){
			this.nbPreflop = 1;
			this.nbFlop = 1;
			this.nbTurn = 1;
			this.nbRiver = 1;
			this.nbShowDown = 1;
		}
	}

	public void incrementerEtape(Etape etape) {
		if (etape == Etape.PREFLOP) {
			this.nbPreflop++;
		}else if(etape == Etape.FLOP){
			this.nbPreflop++;
			this.nbFlop++;
		}else if(etape == Etape.TURN){
			this.nbPreflop++;
			this.nbFlop++;
			this.nbTurn++;
		}else if(etape == Etape.RIVER){
			this.nbPreflop++;
			this.nbFlop++;
			this.nbTurn++;
			this.nbRiver++;
		}else if(etape == Etape.SHOWDOWN){
			this.nbPreflop++;
			this.nbFlop++;
			this.nbTurn++;
			this.nbRiver++;
			this.nbShowDown++;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public Integer getNbPreflop() {
		return nbPreflop;
	}

	public void setNbPreflop(Integer nbPreflop) {
		this.nbPreflop = nbPreflop;
	}

	public Integer getNbFlop() {
		return nbFlop;
	}

	public void setNbFlop(Integer nbFlop) {
		this.nbFlop = nbFlop;
	}

	public Integer getNbTurn() {
		return nbTurn;
	}

	public void setNbTurn(Integer nbTurn) {
		this.nbTurn = nbTurn;
	}

	public Integer getNbRiver() {
		return nbRiver;
	}

	public void setNbRiver(Integer nbRiver) {
		this.nbRiver = nbRiver;
	}

	public Integer getNbShowDown() {
		return nbShowDown;
	}

	public void setNbShowDown(Integer nbShowDown) {
		this.nbShowDown = nbShowDown;
	}

	public Joueur() {
		super();
	}

	public Joueur(Integer id, String nomJoueur, Integer nbPreflop, Integer nbFlop, Integer nbTurn, Integer nbRiver,
			Integer nbShowDown) {
		super();
		this.id = id;
		this.nomJoueur = nomJoueur;
		this.nbPreflop = nbPreflop;
		this.nbFlop = nbFlop;
		this.nbTurn = nbTurn;
		this.nbRiver = nbRiver;
		this.nbShowDown = nbShowDown;
	}

	
	
}
