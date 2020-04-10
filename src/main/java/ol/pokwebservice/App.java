package ol.pokwebservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Main;
import ol.pokwebservice.objects.Prevision;
import ol.pokwebservice.objects.Resolution;
import ol.pokwebservice.objects.enums.ValeurCarte;
import ol.pokwebservice.utils.AllUtils;
import ol.pokwebservice.utils.CartesUtils;
import ol.pokwebservice.utils.CombinaisonUtils;

public class App {

	public static void main(String[] args) {
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = AllUtils.getRandomNumberInRange(10, 30);
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
		
	}
}
