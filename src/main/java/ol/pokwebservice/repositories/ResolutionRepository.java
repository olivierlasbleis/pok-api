package ol.pokwebservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.Resolution;

@Repository
public interface ResolutionRepository extends JpaRepository<Resolution, Integer>{

	@Query("SELECT c FROM Resolution c WHERE c.carte0 = ?1 and c.carte1 = ?2 and c.carte2 = ?3 and c.carte3 = ?4 and c.carte4 = ?5 and c.carte5 = ?6 and c.carte6 = ?7")
	List<Resolution> findByCartes(Carte carte0, Carte carte1, Carte carte2, Carte carte3, Carte carte4, Carte carte5,
			Carte carte6);

	
	

}
