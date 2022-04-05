package com.augusto.springboot.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augusto.springboot.productos.models.Dao.productosDao;
import com.augusto.springboot.productos.models.entity.Producto;

@Service
public class productoService implements IProductoService  {
	
	@Autowired
	productosDao proddao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		
		return (List<Producto>)proddao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		
		return proddao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
	
		return proddao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
	proddao.deleteById(id);
		
	}

	
}
