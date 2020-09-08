package ol.pokwebservice.objects.vues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Data;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Prevision;
import ol.pokwebservice.services.PrevisionService;


public class PrevisionVue {
	
	private double pourcentageDeGagne;
	private RangeVue[][] rangeVue;

	
	

	public PrevisionVue(double pourcentageDeGagne, RangeVue[][] rangeVue) {
		super();
		this.rangeVue = rangeVue;
		this.pourcentageDeGagne = pourcentageDeGagne;
	}

	public PrevisionVue() {
		super();
	}

	

	public double getPourcentageDeGagne() {
		return pourcentageDeGagne;
	}

	public void setPourcentageDeGagne(double pourcentageDeGagne) {
		this.pourcentageDeGagne = pourcentageDeGagne;
	}

	public RangeVue[][] getRangeVue() {
		return rangeVue;
	}

	public void setRangeVue(RangeVue[][] rangeVue) {
		this.rangeVue = rangeVue;
	}

	
	
	

}
