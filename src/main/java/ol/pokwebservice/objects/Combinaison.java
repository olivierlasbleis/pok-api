package ol.pokwebservice.objects;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.objects.enums.ValeurCombinaison;
import ol.pokwebservice.utils.CartesUtils;

@Data
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
		}else if ( this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) == 0
				&& this.getCartesCombinaison().size()>0
				&& this.getCartesCombinaison().get(0).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(0).getValeurCarte())!=0) {
			return this.getCartesCombinaison().get(0).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(0).getValeurCarte());
		}else if (this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) == 0
				&& this.getCartesCombinaison().size()>1
				&& this.getCartesCombinaison().get(1).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(1).getValeurCarte())!=0) {
			return this.getCartesCombinaison().get(1).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(1).getValeurCarte());
		}else if (this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) == 0
				&& this.getCartesCombinaison().size()>2
				&& this.getCartesCombinaison().get(2).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(2).getValeurCarte())!=0) {
			return this.getCartesCombinaison().get(2).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(2).getValeurCarte());
		}else if (this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) == 0
				&& this.getCartesCombinaison().size()>3
				&& this.getCartesCombinaison().get(3).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(3).getValeurCarte())!=0) {
			return this.getCartesCombinaison().get(3).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(3).getValeurCarte());
		}else if (this.getValeurCombinaison().compareTo(combinaison.getValeurCombinaison()) == 0
				&& this.getCartesCombinaison().size()>4
				&& this.getCartesCombinaison().get(4).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(4).getValeurCarte())!=0) {
			return this.getCartesCombinaison().get(4).getValeurCarte().compareTo(combinaison.getCartesCombinaison().get(4).getValeurCarte());
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



	public ValeurCombinaison getValeurCombinaison() {
		return valeurCombinaison;
	}



	public void setValeurCombinaison(ValeurCombinaison valeurCombinaison) {
		this.valeurCombinaison = valeurCombinaison;
	}



	public List<Carte> getCartesCombinaison() {
		return cartesCombinaison;
	}



	public void setCartesCombinaison(List<Carte> cartesCombinaison) {
		this.cartesCombinaison = cartesCombinaison;
	}



	public List<Carte> getCartesRestantes() {
		return cartesRestantes;
	}



	public void setCartesRestantes(List<Carte> cartesRestantes) {
		this.cartesRestantes = cartesRestantes;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Combinaison() {
		super();
	}
	
}
