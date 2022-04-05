package com.augusto.springboot.productositems.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.augusto.springboot.productositems.models.entity.Items;
import com.augusto.springboot.productositems.models.entity.Producto;

@Service
public class itemServiceImpl implements itemService {

	@Autowired
	private RestTemplate ClienteRest;
	
	@Override
	public List<Items> findAll() {
		
		/*List<Producto> productos = ClienteRest.getForObject("http://localhost:8001/listar", Producto[].class) 
		 * 
		 * Lo que hacemos arriba es traer un arreglo de productos desde el clienteRest(desde otro microservicio), el siguiente 
		 * paso seria transformar ese arreglo en una lista*/
		
		List<Producto> productos = Arrays.asList(ClienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		
		/*obtuvimos una lista de productos pero nuestro metodo retorna una lista de Items, asi que debemos hacer esa conversion*/
		/*Stream vuelve a productos en un flujo, con map pasamos a cada producto a un Item y luego la volvemos una lista con collectors*/
		return productos.stream().map(p ->  new Items(p,1)).collect(Collectors.toList());
	}

	@Override
	public Items findById(Long id, Integer cantidad) {
		
		/*obtenemos producto mediante clienteRest pero como necesitamos uno especifico, debemos pasarle como tercer argumento a getForObjetc
		 * un map del producto, que va a tener dos string uno con el nombre (id) y otro con el valor (id) y por ultimo debo retornar un 
		 * Item por lo que debo generarlo con el producto que traje y la cantidad pasada por parametro */
		
		Map<String ,String> pathVariablesMap = new HashMap<String, String>();
		pathVariablesMap.put("id", id.toString());
		Producto producto = ClienteRest.getForObject("http://localhost:8001/listar/ver/{di}", Producto.class, pathVariablesMap);
		return new Items(producto, cantidad);
		
	}

	@Override
	public Producto saveProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto updateProducto(Producto producto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
