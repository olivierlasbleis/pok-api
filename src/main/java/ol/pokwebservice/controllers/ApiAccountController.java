package ol.pokwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ol.pokwebservice.objects.ApiAccount;
import ol.pokwebservice.services.ApiAccountService;

@RestController
public class ApiAccountController {
	
	@Autowired
	ApiAccountService apiAccountService;

	@GetMapping("/getApiKey")
	public String getApiKey() {
		return apiAccountService.save(new ApiAccount()).getId();
	}
}
