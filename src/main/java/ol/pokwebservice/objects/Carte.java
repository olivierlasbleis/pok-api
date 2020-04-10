package ol.pokwebservice.objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.objects.vues.CarteVue;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Enumerated(EnumType.STRING)
	ValeurCarte valeurCarte;
	@Enumerated(EnumType.STRING)
	SigneCarte signeCarte;

	public CarteVue instancierCarteVue() {
			String nomCarte = "";
			if (this.valeurCarte == ValeurCarte.AS) {
				nomCarte = "A";
			}else if (this.valeurCarte == ValeurCarte.ROI) {
				nomCarte = "K";
			}else if (this.valeurCarte == ValeurCarte.DAME) {
				nomCarte = "Q";
			}else if (this.valeurCarte == ValeurCarte.VALET) {
				nomCarte = "J";
			}else if (this.valeurCarte == ValeurCarte.DIX) {
				nomCarte = "10";
			}else if (this.valeurCarte == ValeurCarte.NEUF) {
				nomCarte = "9";
			}else if (this.valeurCarte == ValeurCarte.HUIT) {
				nomCarte = "8";
			}else if (this.valeurCarte == ValeurCarte.SEPT) {
				nomCarte = "7";
			}else if (this.valeurCarte == ValeurCarte.SIX) {
				nomCarte = "6";
			}else if (this.valeurCarte == ValeurCarte.CINQ) {
				nomCarte = "5";
			}else if (this.valeurCarte == ValeurCarte.QUATRE) {
				nomCarte = "4";
			}else if (this.valeurCarte == ValeurCarte.TROIS) {
				nomCarte = "3";
			}else if (this.valeurCarte == ValeurCarte.DEUX) {
				nomCarte = "2";
			}
			String signeCarte = "";
			if (this.signeCarte == SigneCarte.CARREAU) {
						signeCarte = "d";
			}else if (this.signeCarte == SigneCarte.COEUR) {
				signeCarte = "h";
			}else if (this.signeCarte == SigneCarte.PIQUE) {
				signeCarte = "s";
			}else if (this.signeCarte == SigneCarte.TREFLE) {
				signeCarte = "c";
			} 
					
			return new CarteVue(nomCarte , signeCarte);
			
	}

	public Carte(ValeurCarte valeurCarte, SigneCarte signeCarte) {
		super();
		this.valeurCarte = valeurCarte;
		this.signeCarte = signeCarte;
	}
}
