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
				nomCarte = "as";
			}else if (this.valeurCarte == ValeurCarte.AS) {
				nomCarte = "as";
			}else if (this.valeurCarte == ValeurCarte.ROI) {
				nomCarte = "roi";
			}else if (this.valeurCarte == ValeurCarte.DAME) {
				nomCarte = "dame";
			}else if (this.valeurCarte == ValeurCarte.VALET) {
				nomCarte = "valet";
			}else if (this.valeurCarte == ValeurCarte.DIX) {
				nomCarte = "dix";
			}else if (this.valeurCarte == ValeurCarte.NEUF) {
				nomCarte = "neuf";
			}else if (this.valeurCarte == ValeurCarte.HUIT) {
				nomCarte = "huit";
			}else if (this.valeurCarte == ValeurCarte.SEPT) {
				nomCarte = "sept";
			}else if (this.valeurCarte == ValeurCarte.SIX) {
				nomCarte = "six";
			}else if (this.valeurCarte == ValeurCarte.CINQ) {
				nomCarte = "cinq";
			}else if (this.valeurCarte == ValeurCarte.QUATRE) {
				nomCarte = "quatre";
			}else if (this.valeurCarte == ValeurCarte.TROIS) {
				nomCarte = "trois";
			}else if (this.valeurCarte == ValeurCarte.DEUX) {
				nomCarte = "deux";
			}
			String signeCarte = "";
			if (this.signeCarte == SigneCarte.CARREAU) {
						signeCarte = "Ca";
			}else if (this.signeCarte == SigneCarte.COEUR) {
				signeCarte = "Co";
			}else if (this.signeCarte == SigneCarte.PIQUE) {
				signeCarte = "Pi";
			}else if (this.signeCarte == SigneCarte.TREFLE) {
				signeCarte = "Tr";
			} 
					
			return new CarteVue(nomCarte , signeCarte);
			
	}

	public Carte(ValeurCarte valeurCarte, SigneCarte signeCarte) {
		super();
		this.valeurCarte = valeurCarte;
		this.signeCarte = signeCarte;
	}
}
