package ol.pokwebservice.objects.vues;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Prevision;

@Data
public class PrevisionVue {
	
	private double[][] rangeDeGagne;
	private double pourcentageDeGagne;
	private List<CarteVue> cartes;
	
	public PrevisionVue(Prevision prevision) {
		this.rangeDeGagne = prevision.getRangePrevision();
		this.pourcentageDeGagne = prevision.getPourcentageGagne();
		this.cartes = new ArrayList<CarteVue>();
		for (Carte carte : prevision.getCartes()) {
			this.cartes.add(carte.instancierCarteVue());
		}		;
	}

}
