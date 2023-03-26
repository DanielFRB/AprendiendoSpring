package com.dfrb.hibernate;

import javax.persistence.*;

/**
 * @author dfrb@ne
 */

@Entity
@Table(name = "clientes")
public class Clientes {
	public Clientes() {
	}
	
	public Clientes(String nombres, String apellidos, String direccion) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}

	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "direccion")
	private String direccion;
}
