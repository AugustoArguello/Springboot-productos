package com.augusto.springboot.productositems;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*nos permite crear objetos del tipo beans, que sirven para
enlazar dos microservicios */ 

@Configuration
public class appiRestConfig {
	
	/*registramos un Rest Template para injectarlo, esto nos permite 
	trabajar con recursos de otros microservicios*/
	
	@Bean("clienteRest")
	
	public RestTemplate registraRestTemplate() {
		return new RestTemplate();
	}

}
