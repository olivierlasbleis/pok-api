package ol.pokwebservice.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import ol.pokwebservice.services.ResolutionService;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;

@Data
public class Prevision {
	
	//cette liste est de 5, 6 ou 7 cartes, 
	//les deux premières sont celle du joueur, 
	//les autres celle du flop
	private List<Carte> cartes;
	private List<Resolution> resolutions;
	private double[][] rangePrevision;
	private double pourcentageGagne;
	
	public Prevision(List<Carte> cartes, List<Resolution> resolutions, double[][] rangePrevision,
			double pourcentageGagne) {
		super();
		this.cartes = cartes;
		this.resolutions = resolutions;
		this.rangePrevision = rangePrevision;
		this.pourcentageGagne = pourcentageGagne;
	}
	
	

}
