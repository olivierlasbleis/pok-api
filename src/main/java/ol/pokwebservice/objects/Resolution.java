package ol.pokwebservice.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.repositories.CarteRepository;
import ol.pokwebservice.repositories.ResolutionRepository;
import ol.pokwebservice.services.CarteService;
import ol.pokwebservice.services.ResolutionService;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;
import ol.pokwebservice.utils.CombinaisonUtils;
import ol.pokwebservice.utils.MainsUtils;

@Data
@Entity
@NoArgsConstructor
public class Resolution {
	
	//cette liste est de minimum 7 cartes, 
	//les deux premières sont celle du joueur, 
	//les autres celle du flop
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte0;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte1;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte2;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte3;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte4;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte5;
	@ManyToOne(cascade = CascadeType.ALL)
	Carte carte6;
	
	@Transient
	List<Carte> cartes;
	@Transient
	Combinaison combinaisonMax;
	@Transient
	List<Main> mainsQueJeBat;
	@Transient
	List<Main> mainsAdversairePossibles;
	double pourcentageGagne;
	@Lob
	double[][] rangeResolution = new double[13][13];
	
	
	@Transient
	@Autowired
	ResolutionService resolutionService;
	
	@Transient
	@Autowired
	CarteService carteService;
	
	
	
	/**
	 * Ce constructeur crée un objet Resolution à partir d'une main et de 5 cartes du flop.
	 * Il calcule les mains possibles de l'adversaire et pour chacune d'entre elle le resultat contre la main du joueur
	 * @param mainJoueur
	 * @param cartesFlop
	 */
	
	public Resolution(Main mainJoueur, List<Carte> cartesFlop, List<Main> mainsAdversairePossibles) {
		
		this.mainsAdversairePossibles = mainsAdversairePossibles;
		
		List<Carte> cartesFlopJoueur  = new ArrayList<Carte>(cartesFlop);
		cartesFlopJoueur.add(mainJoueur.getCarte1());
		cartesFlopJoueur.add(mainJoueur.getCarte2());
		cartesFlopJoueur = CartesUtils.trierCartesParValeur(cartesFlopJoueur);
		
		this.carte0 = cartesFlopJoueur.get(0); 
		this.carte1 = cartesFlopJoueur.get(1); 
		this.carte2 = cartesFlopJoueur.get(2); 
		this.carte3 = cartesFlopJoueur.get(3); 
		this.carte4 = cartesFlopJoueur.get(4); 
		this.carte5 = cartesFlopJoueur.get(5); 
		this.carte6 = cartesFlopJoueur.get(6); 
			
			
		this.cartes = cartesFlopJoueur;
		this.combinaisonMax = CombinaisonUtils.determinerCombinaisonMaxAvec7Cartes(cartesFlopJoueur);
		this.mainsQueJeBat = new ArrayList<Main>();
		
		
		this.calculerMainsQueJeBatEtRangeResolution(cartesFlop);
		this.pourcentageGagne = this.mainsQueJeBat.size() * 1.0 / this.mainsAdversairePossibles.size();
	}
	
	private Optional<Carte> findByValeurCarteAndSigneCarte(ValeurCarte valeurCarte, SigneCarte signeCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	private void calculerMainsQueJeBatEtRangeResolution(List<Carte> cartesFlopCommunes) {

		int[][] rangeMainsPossibles = new int[13][13];
		
		Stream streamMainsAdversairePossibles = this.mainsAdversairePossibles.stream();
		streamMainsAdversairePossibles.forEach(mainAdversaire -> {
			rangeMainsPossibles[((Main) mainAdversaire).getI()][((Main) mainAdversaire).getJ()] = 
					rangeMainsPossibles[((Main) mainAdversaire).getI()][((Main) mainAdversaire).getJ()] + 1;
			List<Carte> cartesFlopAdversaire = new ArrayList<Carte>(cartesFlopCommunes);
			cartesFlopAdversaire.add(((Main) mainAdversaire).getCarte1());
			cartesFlopAdversaire.add(((Main) mainAdversaire).getCarte2());
			Combinaison combinaisonMaxAdversaire = CombinaisonUtils.determinerCombinaisonMaxAvec7Cartes(cartesFlopAdversaire);
			if (combinaisonMaxAdversaire.compareTo(
					this.combinaisonMax) < 0) {
				this.mainsQueJeBat.add((Main) mainAdversaire);
			}
		});
		
		double[][] range = new double[13][13];
		
		Stream streamMainsQueJeBat = this.mainsQueJeBat.stream();
		streamMainsQueJeBat.forEach(main -> 
			range[((Main) main).getI()][((Main) main).getJ()] = 
				range[((Main) main).getI()][((Main) main).getJ()] + 1.0);
		
		for (int i = 0; i < range.length; i++) {
			for (int j = 0; j < range[i].length; j++) {
				if (i == j) {
					range[i][j] = range[i][j] * 1.0 / rangeMainsPossibles[i][j];
				}else if (i > j) {
					range[i][j] = range[i][j] * 1.0 / rangeMainsPossibles[i][j];
				}else if (i < j) {
					range[i][j] = range[i][j] * 1.0 / rangeMainsPossibles[i][j];
				}
			}
		}
		this.rangeResolution =  range;
		
	}

	private double[][] calculerLaRangeLocale(List<Main> listeDesMainsQueJeBat){
		
		
		int[][] rangeMainsPossibles = new int[13][13];
		for (Main main : this.mainsAdversairePossibles ) {
			rangeMainsPossibles[main.getI()][main.getJ()] = rangeMainsPossibles[main.getI()][main.getJ()] + 1;
		}
		double[][] range = new double[13][13];
		for (Main main : listeDesMainsQueJeBat) {
			range[main.getI()][main.getJ()] = range[main.getI()][main.getJ()] + 1.0 ;
		}
		for (int i = 0; i < range.length; i++) {
			for (int j = 0; j < range[i].length; j++) {
				if (i == j) {
					range[i][j] = AllUtils.round(range[i][j] * 1.0 / rangeMainsPossibles[i][j],1);
				}else if (i > j) {
					range[i][j] = AllUtils.round(range[i][j] * 1.0 / rangeMainsPossibles[i][j],1);
				}else if (i < j) {
					range[i][j] = AllUtils.round(range[i][j] * 1.0 / rangeMainsPossibles[i][j],1);
				}
			}
		}
		return range;
	}
}
