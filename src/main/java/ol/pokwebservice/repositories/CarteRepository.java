package ol.pokwebservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Integer>{

	@Query("SELECT c FROM Carte c WHERE c.valeurCarte = ?1 and c.signeCarte = ?2")
	List<Carte> findByValeurCarteAndSigneCarte(ValeurCarte valeurCarte, SigneCarte signeCarte);

	
}
