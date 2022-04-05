package com.augusto.springboot.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "productos")

/*serializable sirve para poder transformar la informacion de nuestra base de datos en bytes, para asi ser enviada y ahorrar recursos*/

public class Producto implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private long id;
	
	private String nombre;
	
	private Double precio;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	
	private Date createAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	private static final long serialVersionUID = 9060005550484095017L;
}
