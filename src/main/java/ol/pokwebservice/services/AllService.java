package ol.pokwebservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AllService {

	@Autowired
	Environment env;
	
	
	public String[] getListColorEchelle(){
		return env.getProperty("code.couleur").split(",");
	}
	}
