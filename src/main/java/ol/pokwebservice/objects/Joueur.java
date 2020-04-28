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
@Data
@NoArgsConstructor
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

	
	
}
