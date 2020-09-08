package ol.pokwebservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.Prevision;
import ol.pokwebservice.objects.vues.PrevisionVue;
import ol.pokwebservice.objects.vues.RangeVue;

@Service
public class PrevisionService {
	
	@Autowired
	 private Environment env;
	
	@Autowired
	 private RangeService rangeService;

	public String[][] convertRangeDeGagneToRangeCouleur(double[][] rangeDeGagne) {
		String[][] rangeCouleur = new String[13][13];
		List<String> codeCouleurs = 
		new ArrayList<String>(Arrays.asList(env.getProperty("code.couleur").split(",")));
		for (int i = 0; i < rangeDeGagne.length; i++) {
			for (int j = 0; j < rangeDeGagne[i].length; j++) {
				if (rangeDeGagne[i][j]<0.1) {
					rangeCouleur[i][j]= codeCouleurs.get(9);
				}else if (rangeDeGagne[i][j]<0.2) {
					rangeCouleur[i][j]= codeCouleurs.get(8);
				}else if (rangeDeGagne[i][j]<0.3) {
					rangeCouleur[i][j]= codeCouleurs.get(7);
				}else if (rangeDeGagne[i][j]<0.4) {
					rangeCouleur[i][j]= codeCouleurs.get(6);
				}else if (rangeDeGagne[i][j]<0.5) {
					rangeCouleur[i][j]= codeCouleurs.get(5);
				}else if (rangeDeGagne[i][j]<0.6) {
					rangeCouleur[i][j]= codeCouleurs.get(4);
				}else if (rangeDeGagne[i][j]<0.7) {
					rangeCouleur[i][j]= codeCouleurs.get(3);
				}else if (rangeDeGagne[i][j]<0.8) {
					rangeCouleur[i][j]= codeCouleurs.get(2);
				}else if (rangeDeGagne[i][j]<0.9) {
					rangeCouleur[i][j]= codeCouleurs.get(1);
				}else {
					rangeCouleur[i][j]= codeCouleurs.get(0);
				}
			}
		}
		return rangeCouleur;
	}

	public PrevisionVue convertPrevisionToPrevisionVue(Prevision prevision) {
		// TODO Auto-generated method stub
		RangeVue[][] rangeVue = rangeService.calculerRangeVue(prevision.getRangePrevision(), convertRangeDeGagneToRangeCouleur(prevision.getRangePrevision()));
		
		return new PrevisionVue(100.0-
				round(prevision.getPourcentageGagne() * 100.0,0), 
				rangeVue);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
