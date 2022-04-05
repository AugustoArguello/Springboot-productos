package com.augusto.springboot.usuarios.oauth.models.Service;

import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;

public interface IUsuarioService {
	
	public Usuarios findByUsername(String username);
	
	public Usuarios update(Usuarios usuario,Long id);

}
