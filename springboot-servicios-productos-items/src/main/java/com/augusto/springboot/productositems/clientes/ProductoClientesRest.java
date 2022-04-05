package com.augusto.springboot.productositems.clientes;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.augusto.springboot.productositems.models.entity.Producto;


@FeignClient(name = "servicio-productos")

public interface ProductoClientesRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/listar/{id}")
	public Producto detalle (@PathVariable long id);
	
	@PostMapping("/crear")
	public Producto crear(@RequestBody Producto producto);
	
	@PutMapping("/editar/{id}")
	public Producto editar (@RequestBody Producto producto, @PathVariable Long id);

	@DeleteMapping("/eliminar/{id}")
	public void borrar(@PathVariable Long id);

}
