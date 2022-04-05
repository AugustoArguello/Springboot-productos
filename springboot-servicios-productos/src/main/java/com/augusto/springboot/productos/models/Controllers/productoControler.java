package com.augusto.springboot.productos.models.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.springboot.productos.models.entity.Producto;
import com.augusto.springboot.productos.models.service.IProductoService;

@RestController
public class productoControler {
	
	@Autowired
	IProductoService productoService;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
	
		return productoService.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Producto detalle (@PathVariable long id){
		
		return productoService.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto (@RequestBody Producto producto) {
		return productoService.save(producto);	
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editarProducto (@RequestBody Producto producto, @PathVariable Long id) {
		Producto prodtem = productoService.findById(id);
		prodtem.setNombre(producto.getNombre());
		prodtem.setPrecio(producto.getPrecio());
				
		return productoService.save(prodtem);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.deleteById(id);
	}
	
}

