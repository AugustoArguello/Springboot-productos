package com.augusto.springboot.productositems.models.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.augusto.springboot.productositems.models.entity.Items;
import com.augusto.springboot.productositems.models.entity.Producto;
import com.augusto.springboot.productositems.models.service.itemService;


@RestController
@Qualifier("serviceFeing")
public class itemsControll {

	private Logger logger = LoggerFactory.getLogger(itemsControll.class);
	
	@Autowired
	private itemService itemService;
	
	@Value("${configuracion.texto}")
	String texto;
	
	@GetMapping("/listar")
	public List<Items> listar(/*@RequestParam(name="nombre") String nombre,@RequestHeader(name= "token-request") String token*/ ){
			
		return itemService.findAll();
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig (@Value("${server.port}") String puerto){
		Map<String,String> json = new HashMap<>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		logger.info(texto);
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
	
	
	@GetMapping("ver/{id}/cantidad/{cantidad}")
	public Items detalleItems (@PathVariable long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	
	
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crearProducto (@RequestBody Producto producto) {
		return itemService.saveProducto(producto);	
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editarProducto (@RequestBody Producto producto, @PathVariable Long id) {
		return itemService.updateProducto(producto, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itemService.delete(id);
	}
	
	
}
