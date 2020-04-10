package ol.pokwebservice.objects.vues;

import lombok.Data;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;

@Data
public class CarteVue {
	
	private String nomCarte;
	private String urlPhoto;
		
	public CarteVue(String nomCarte, String signeCarte) {
		this.nomCarte = nomCarte + signeCarte;
		this.urlPhoto = "http://www.hegerm.ch/images/cartes/";//10h.gif
		if (nomCarte == "as")  {
			this.urlPhoto = this.urlPhoto + "A";
		}else if (nomCarte == "roi")  {
			this.urlPhoto = this.urlPhoto + "K";
		}else if (nomCarte == "dame")  {
			this.urlPhoto = this.urlPhoto + "Q";
		}else if (nomCarte == "valet")  {
			this.urlPhoto =  this.urlPhoto + "J";
		}else if (nomCarte == "dix")  {
			this.urlPhoto = this.urlPhoto + "10";
		}else if (nomCarte == "neuf")  {
			this.urlPhoto = this.urlPhoto + "9";
		}else if (nomCarte == "huit")  {
			this.urlPhoto = this.urlPhoto + "8";
		}else if (nomCarte == "sept")  {
			this.urlPhoto = this.urlPhoto + "7";
		}else if (nomCarte == "six")  {
			this.urlPhoto = this.urlPhoto + "6";
		}else if (nomCarte == "cinq")  {
			this.urlPhoto = this.urlPhoto + "5";
		}else if (nomCarte == "quatre")  {
			this.urlPhoto = this.urlPhoto + "4";
		}else if (nomCarte == "trois")  {
			this.urlPhoto = this.urlPhoto + "3";
		}else if (nomCarte == "deux")  {
			this.urlPhoto = this.urlPhoto + "2";
		}
		
		if (signeCarte ==  "Ca") {
			this.urlPhoto = this.urlPhoto + "d.gif";
		}else if (signeCarte ==  "Co") {
			this.urlPhoto = this.urlPhoto + "h.gif";
		}else if (signeCarte ==  "Pi") {
			this.urlPhoto = this.urlPhoto + "s.gif";
		}else if (signeCarte ==  "Tr") {
			this.urlPhoto = this.urlPhoto + "c.gif";
		} 
		
		//this.urlPhoto = cartesRepository.findByNomCarte().get().getUrlPhoto; 
		//http://www.hegerm.ch/images/cartes/10h.gif
	}
}


