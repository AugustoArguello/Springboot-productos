package com.augusto.springboot.productositems.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.augusto.springboot.productositems.clientes.ProductoClientesRest;
import com.augusto.springboot.productositems.models.entity.Items;
import com.augusto.springboot.productositems.models.entity.Producto;

@Service("serviceFeing")
@Primary
public class itemSErviceFeing implements itemService {

	@Autowired
	private ProductoClientesRest clienteFeingRest; 
	
	@Override
	public List<Items> findAll() {
	
		return clienteFeingRest.listar().stream().map(p ->  new Items(p,1)).collect(Collectors.toList());
	}

	@Override
	public Items findById(Long id, Integer cantidad) {
		return new Items(clienteFeingRest.detalle(id), cantidad);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		
		return clienteFeingRest.crear(producto);
	}

	@Override
	public void delete(Long id) {
		clienteFeingRest.borrar(id);		
	}

	@Override
	public Producto updateProducto(Producto producto, Long id) {
		
		return clienteFeingRest.editar(producto, id);
	}

}
