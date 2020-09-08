package ol.pokwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.vues.RangeVue;

@Service
public class RangeService {
	
	@Autowired
	 private Environment env;

	public RangeVue[][] calculerRangeVue(double[][] rangeDeGagne, String[][] rangeCouleur) {
		RangeVue[][] rangeVue = new RangeVue[13][13];
		String[][] tabTabMains = new String[13][13];
		String[] tabMains = env.getProperty("mains").split("/");
		for (int i = 0; i < tabMains.length; i++) {
			tabTabMains[i] = tabMains[i].split(",");
		}
		for (int i = 0; i < tabTabMains.length; i++) {
			for (int j = 0; j < tabTabMains[i].length; j++) {
				rangeVue[i][j] = new RangeVue(tabTabMains[i][j],round(rangeDeGagne[i][j] * 100,0),rangeCouleur[i][j]);
			}
		}
		return rangeVue;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
