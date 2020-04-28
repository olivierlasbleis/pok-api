package ol.pokwebservice.objects.vues;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.Joueur;
import ol.pokwebservice.objects.enums.Etape;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurPostVue {

	private String nomJoueur;
	private Etape etape;
	
	
	public JoueurPostVue(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	public Joueur transFormToJoueur() {
		return new Joueur(this.nomJoueur, this.etape);
	}
	
}
