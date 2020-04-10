package ol.pokwebservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Main;
import ol.pokwebservice.objects.Prevision;
import ol.pokwebservice.objects.Resolution;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;
import ol.pokwebservice.utils.CombinaisonUtils;

public class App {

	public static void main(String[] args) {

		Carte asCa = new Carte(ValeurCarte.AS,SigneCarte.CARREAU);
    	Carte roiCa = new Carte(ValeurCarte.ROI,SigneCarte.CARREAU);
    	Carte dameCa = new Carte(ValeurCarte.DAME,SigneCarte.CARREAU);
    	Carte valetCa = new Carte(ValeurCarte.VALET,SigneCarte.CARREAU);
    	Carte dixCa = new Carte(ValeurCarte.DIX,SigneCarte.CARREAU);
    	Carte neufCa = new Carte(ValeurCarte.NEUF,SigneCarte.CARREAU);
    	Carte huitCa = new Carte(ValeurCarte.HUIT,SigneCarte.CARREAU);
    	Carte septCa = new Carte(ValeurCarte.SEPT,SigneCarte.CARREAU);
    	Carte sixCa = new Carte(ValeurCarte.SIX,SigneCarte.CARREAU);
    	Carte cinqCa = new Carte(ValeurCarte.CINQ,SigneCarte.CARREAU);
    	Carte quatreCa = new Carte(ValeurCarte.QUATRE,SigneCarte.CARREAU);
    	Carte troisCa = new Carte(ValeurCarte.TROIS,SigneCarte.CARREAU);
    	Carte deuxCa = new Carte(ValeurCarte.DEUX,SigneCarte.CARREAU);
    	
    	Carte asCo = new Carte(ValeurCarte.AS,SigneCarte.COEUR);
    	Carte roiCo = new Carte(ValeurCarte.ROI,SigneCarte.COEUR);
    	Carte dameCo = new Carte(ValeurCarte.DAME,SigneCarte.COEUR);
    	Carte valetCo = new Carte(ValeurCarte.VALET,SigneCarte.COEUR);
    	Carte dixCo = new Carte(ValeurCarte.DIX,SigneCarte.COEUR);
    	Carte neufCo = new Carte(ValeurCarte.NEUF,SigneCarte.COEUR);
    	Carte huitCo = new Carte(ValeurCarte.HUIT,SigneCarte.COEUR);
    	Carte septCo = new Carte(ValeurCarte.SEPT,SigneCarte.COEUR);
    	Carte sixCo = new Carte(ValeurCarte.SIX,SigneCarte.COEUR);
    	Carte cinqCo = new Carte(ValeurCarte.CINQ,SigneCarte.COEUR);
    	Carte quatreCo = new Carte(ValeurCarte.QUATRE,SigneCarte.COEUR);
    	Carte troisCo = new Carte(ValeurCarte.TROIS,SigneCarte.COEUR);
    	Carte deuxCo = new Carte(ValeurCarte.DEUX,SigneCarte.COEUR);
    	
    	Carte asTr = new Carte(ValeurCarte.AS,SigneCarte.TREFLE);
    	Carte roiTr = new Carte(ValeurCarte.ROI,SigneCarte.TREFLE);
    	Carte dameTr = new Carte(ValeurCarte.DAME,SigneCarte.TREFLE);
    	Carte valetTr = new Carte(ValeurCarte.VALET,SigneCarte.TREFLE);
    	Carte dixTr = new Carte(ValeurCarte.DIX,SigneCarte.TREFLE);
    	Carte neufTr = new Carte(ValeurCarte.NEUF,SigneCarte.TREFLE);
    	Carte huitTr = new Carte(ValeurCarte.HUIT,SigneCarte.TREFLE);
    	Carte septTr = new Carte(ValeurCarte.SEPT,SigneCarte.TREFLE);
    	Carte sixTr = new Carte(ValeurCarte.SIX,SigneCarte.TREFLE);
    	Carte cinqTr = new Carte(ValeurCarte.CINQ,SigneCarte.TREFLE);
    	Carte quatreTr = new Carte(ValeurCarte.QUATRE,SigneCarte.TREFLE);
    	Carte troisTr = new Carte(ValeurCarte.TROIS,SigneCarte.TREFLE);
    	Carte deuxTr = new Carte(ValeurCarte.DEUX,SigneCarte.TREFLE);
    	
    	Carte asPi = new Carte(ValeurCarte.AS,SigneCarte.PIQUE);
    	Carte roiPi = new Carte(ValeurCarte.ROI,SigneCarte.PIQUE);
    	Carte damePi = new Carte(ValeurCarte.DAME,SigneCarte.PIQUE);
    	Carte valetPi = new Carte(ValeurCarte.VALET,SigneCarte.PIQUE);
    	Carte dixPi = new Carte(ValeurCarte.DIX,SigneCarte.PIQUE);
    	Carte neufPi = new Carte(ValeurCarte.NEUF,SigneCarte.PIQUE);
    	Carte huitPi = new Carte(ValeurCarte.HUIT,SigneCarte.PIQUE);
    	Carte septPi = new Carte(ValeurCarte.SEPT,SigneCarte.PIQUE);
    	Carte sixPi = new Carte(ValeurCarte.SIX,SigneCarte.PIQUE);
    	Carte cinqPi = new Carte(ValeurCarte.CINQ,SigneCarte.PIQUE);
    	Carte quatrePi = new Carte(ValeurCarte.QUATRE,SigneCarte.PIQUE);
    	Carte troisPi = new Carte(ValeurCarte.TROIS,SigneCarte.PIQUE);
    	Carte deuxPi = new Carte(ValeurCarte.DEUX,SigneCarte.PIQUE);
    	
    	List<Carte> cartesFlop = Arrays.asList(deuxPi, cinqPi, valetPi);
    	Main mainJoueur = new Main(cinqCo, valetCo);
    	//List<Carte> listeCarteOccurence = CartesUtils.obtenirOccurenceMax(listeCarte);
    	//List<Carte> listeCarteSorted = CartesUtils.trierCartesParValeur(listeCarte);
    	//List<Carte> listeGetFromTo = AllUtils.getFromTo(listeCarte, 0, 4);
    	
    	long startTime = System.currentTimeMillis();
    	Prevision prevision = new Prevision(mainJoueur, cartesFlop);
    	long exTime = System.currentTimeMillis() - startTime;
    	System.out.println(exTime);
    	
    	double moyenne = 0.0;
    	for (int i = 0; i < prevision.getRangePrevision().length; i++) {
    		for (int j = 0; j < prevision.getRangePrevision()[i].length; j++) {
    			moyenne = moyenne + prevision.getRangePrevision()[i][j];
    			System.out.print(round(prevision.getRangePrevision()[i][j],1) + "--"); 
    		}
    		System.out.println();
		}
    	moyenne = moyenne / 169;
    	System.out.println();
    	System.out.println("POURCENTAGE DE GAGNER : " + prevision.getPourcentageGagne());
    	System.out.println("MOYENNE DE RANGE : " + moyenne);

	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
