package ol.pokwebservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ol.pokwebservice.objects.ApiAccount;
import ol.pokwebservice.objects.Carte;
import ol.pokwebservice.objects.enums.SigneCarte;
import ol.pokwebservice.objects.enums.ValeurCarte;

@Repository
public interface ApiAccountRepository extends JpaRepository<ApiAccount, String>{

	Optional<ApiAccount> findById(String apiAccountId);
	
	

}
