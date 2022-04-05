package com.augusto.springboot.productositems.models.service;

import java.util.List;

import com.augusto.springboot.productositems.models.entity.Items;
import com.augusto.springboot.productositems.models.entity.Producto;

public interface itemService {
	
	public List<Items> findAll();
	
	public Items findById(Long id, Integer cantidad );
	
	public Producto saveProducto (Producto producto);
	
	public void delete(Long id);
	
	public Producto updateProducto(Producto producto, Long id);

}
