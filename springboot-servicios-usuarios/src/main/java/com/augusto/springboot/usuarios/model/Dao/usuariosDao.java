package com.augusto.springboot.usuarios.model.Dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;




@RepositoryRestResource(path = "usuarios")
public interface usuariosDao extends PagingAndSortingRepository<Usuarios,Long>{
	
	public Usuarios findByUsername(String username);
	
	
}
