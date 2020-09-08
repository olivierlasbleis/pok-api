package ol.pokwebservice.objects.vues;

import lombok.Data;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;


public class CarteVue {
	
	private String nomCarte;
	private String urlPhoto;
		
	
	
	public CarteVue(String nomCarte, String signeCarte) {
		if (signeCarte == null) {
			this.nomCarte = nomCarte;
		}else {
			this.nomCarte = nomCarte + signeCarte;
		}
		
		this.urlPhoto = "http://www.hegerm.ch/images/cartes/" + nomCarte + signeCarte + ".gif";//10h.gif
		
	}



	public String getNomCarte() {
		return nomCarte;
	}



	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}



	public String getUrlPhoto() {
		return urlPhoto;
	}



	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
}


