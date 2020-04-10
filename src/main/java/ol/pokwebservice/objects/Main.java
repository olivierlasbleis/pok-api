package ol.pokwebservice.objects;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ol.pokwebservice.utils.CartesUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {
	
	Carte carte1;
	Carte carte2;
	int i;
	int j;
	
	public Main(Carte carte1, Carte carte2) {
		super();
		this.carte1 = CartesUtils.trierCartesParValeur(Arrays.asList(carte1, carte2)).get(1);
		this.carte2 = CartesUtils.trierCartesParValeur(Arrays.asList(carte1, carte2)).get(0);
		if (this.carte1.getSigneCarte() == this.carte2.getSigneCarte()) {
			this.i = 12 - this.carte2.getValeurCarte().ordinal();
			this.j = 12 - this.carte1.getValeurCarte().ordinal();
		}else {
			this.i = 12 - this.carte1.getValeurCarte().ordinal();
			this.j = 12 - this.carte2.getValeurCarte().ordinal();
		}
	}
	
	

}
