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

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public List<Resolution> getResolutions() {
		return resolutions;
	}

	public void setResolutions(List<Resolution> resolutions) {
		this.resolutions = resolutions;
	}

	public double[][] getRangePrevision() {
		return rangePrevision;
	}

	public void setRangePrevision(double[][] rangePrevision) {
		this.rangePrevision = rangePrevision;
	}

	public double getPourcentageGagne() {
		return pourcentageGagne;
	}

	public void setPourcentageGagne(double pourcentageGagne) {
		this.pourcentageGagne = pourcentageGagne;
	}
	
	

}
