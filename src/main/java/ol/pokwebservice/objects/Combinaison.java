package ol.pokwebservice.objects;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.CartesUtils;

@Data
@NoArgsConstructor
public class Combinaison {
	
	
	ValeurCombinaison valeurCombinaison;
	List<Carte> cartesCombinaison;
	List<Carte> cartesRestantes;
	String description;

	
	
	public Combinaison(Combinaison combinaison) {
		this.valeurCombinaison = combinaison.getValeurCombinaison();
		this.cartesCombinaison = combinaison.getCartesCombinaison();
		this.cartesRestantes = combinaison.getCartesRestantes();
		this.description = combinaison.getDescription();
	}



	public Combinaison(ValeurCombinaison valeurCombinaison, List<Carte> cartesCombinaison, List<Carte> cartesRestantes,
			String description) {
		super();
		this.valeurCombinaison = valeurCombinaison;
		this.cartesCombinaison = cartesCombinaison;
		this.cartesRestantes = cartesRestantes;
		this.description = description;
	}
	
	public int compareTo(Combinaison combinaison) {
		if (combinaison== null) {
			return 1;
		} else if (this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) != 0) {
			return this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison());
		}else if (CartesUtils.getCarteMax(this.getCartesCombinaison()).getValeurCarte() 
				.compareTo(CartesUtils.getCarteMax(combinaison.getCartesCombinaison()).getValeurCarte()) != 0){
			return CartesUtils.getCarteMax(this.getCartesCombinaison()).getValeurCarte() 
					.compareTo(CartesUtils.getCarteMax(combinaison.getCartesCombinaison()).getValeurCarte());
		}else if (CartesUtils.getCarteMin(this.getCartesCombinaison()).getValeurCarte() 
				.compareTo(CartesUtils.getCarteMin(combinaison.getCartesCombinaison()).getValeurCarte()) != 0) {
			return CartesUtils.getCarteMin(this.getCartesCombinaison()).getValeurCarte() 
					.compareTo(CartesUtils.getCarteMin(combinaison.getCartesCombinaison()).getValeurCarte());
		}else {
			for (int i = 0; i < this.cartesRestantes.size(); i++) {
				if (this.cartesRestantes.get(i).getValeurCarte().compareTo(
						combinaison.cartesRestantes.get(i).getValeurCarte()) != 0) {
					return this.cartesRestantes.get(i).getValeurCarte().compareTo(
							combinaison.cartesRestantes.get(i).getValeurCarte());
				}
			}
			return 0;
		}
		
		
		
	}
	
}
