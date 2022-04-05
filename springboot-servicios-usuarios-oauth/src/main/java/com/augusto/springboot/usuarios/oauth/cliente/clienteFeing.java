package com.augusto.springboot.usuarios.oauth.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;

@FeignClient(name = "servicio-usuarios")
public interface clienteFeing {

	@GetMapping("/usuarios/search/findByUsername")
	public Usuarios findByUsername(@RequestParam String username);
	
	@PutMapping("/usuarios/{id}")
	public Usuarios update(@RequestBody Usuarios usuario, @PathVariable Long id);

}


