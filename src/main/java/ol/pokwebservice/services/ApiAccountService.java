package ol.pokwebservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ol.pokwebservice.objects.ApiAccount;
import ol.pokwebservice.repositories.ApiAccountRepository;
import ol.pokwebservice.utils.DateUtils;

@Service
public class ApiAccountService {

	@Autowired
	private ApiAccountRepository apiAccountRepository;
	
	public ApiAccount save(ApiAccount apiAccount) {
		return apiAccountRepository.save(apiAccount);
	}
	
	public Optional<ApiAccount> findById(String apiAccountId) {
		return apiAccountRepository.findById(apiAccountId);
	}

	public boolean newCallApi(String apiKey) {
		if (apiAccountRepository.findById(apiKey).isPresent()) {
			ApiAccount currentApiAccount = apiAccountRepository.findById(apiKey).get();
			if (currentApiAccount.getDateAppelApi() == null 
					|| !DateUtils.compareDateUnder24Hours(currentApiAccount.getDateAppelApi())) {
				currentApiAccount.setDateAppelApi(DateUtils.generateDate());
				currentApiAccount.setNbAppelApi(1);
			}else if (DateUtils.compareDateUnder24Hours(currentApiAccount.getDateAppelApi())
					&& currentApiAccount.getNbAppelApi() > 100) {
				return false;
			}else if (DateUtils.compareDateUnder24Hours(currentApiAccount.getDateAppelApi())) {
				currentApiAccount.setNbAppelApi(currentApiAccount.getNbAppelApi() + 1);
			}
			apiAccountRepository.save(currentApiAccount);
			return true;
		}else {
			return false;
		}
		
	}
}
