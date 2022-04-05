package com.augusto.springboot.productos.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.augusto.springboot.productos.models.entity.Producto;

public interface productosDao extends CrudRepository <Producto, Long > {
	
	
}
