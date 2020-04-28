package ol.pokwebservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Joueur;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer>{

	@Query("SELECT c FROM Joueur c WHERE c.nomJoueur = ?1")
	List<Joueur> findByNomJoueur(String nomJoueur);

}
