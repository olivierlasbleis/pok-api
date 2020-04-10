package ol.pokwebservice.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;

public class AllUtils {
	
	public static <T> List<T> getFromTo(List<T> liste, int i, int j){
		List<T> nouvelleListe = new ArrayList<T>();
		int n;
		for (n = i; n <= j ; n++) {
			nouvelleListe.add(liste.get(n));
		}
		return nouvelleListe;
		
	}
	
	public static <T> List<List<T>> getIterations(List<T> liste, int i, int j){
		
		List<int[]> iterations = genererTableauxIterations(i, j);
		List<List<T>> listeRetour = new ArrayList<List<T>>();
		for (int[] iteration : iterations) {
			List<T> listT = new ArrayList<T>();
			for (int it : iteration) {
				listT.add(liste.get(it));
			}
			listeRetour.add(listT);
		}
		
		return listeRetour;
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
	    if (index == data.length) {
	        int[] combination = data.clone();
	        combinations.add(combination);
	    } else if (start <= end) {
	        data[index] = start;
	        helper(combinations, data, start + 1, end, index + 1);
	        helper(combinations, data, start + 1, end, index);
	    }
	}
	
	public static List<int[]> genererTableauxIterations(int n, int r) {
	    List<int[]> combinations = new ArrayList<int[]>();
	    helper(combinations, new int[r], 0, n-1, 0);
	    return combinations;
	}

}
