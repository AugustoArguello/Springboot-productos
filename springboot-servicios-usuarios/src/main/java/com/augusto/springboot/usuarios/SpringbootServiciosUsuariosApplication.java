package com.augusto.springboot.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.augusto.springboot.commons.usuarios.models.Entity")
public class SpringbootServiciosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosUsuariosApplication.class, args);
	}

}
