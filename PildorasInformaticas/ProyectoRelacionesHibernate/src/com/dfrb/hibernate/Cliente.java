package com.dfrb.hibernate;

import java.util.*;

import javax.persistence.*;

/**
 * @author dfrb@ne
 */

@Entity
@Table(name = "cliente")
public class Cliente {
	public Cliente() {
	}
	
	public Cliente(String nombres, String apellidos, String direccion) {
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
	
	public DetalleCliente getDetalleCliente() {
		return detalleCliente;
	}

	public void setDetalleCliente(DetalleCliente detalleCliente) {
		this.detalleCliente = detalleCliente;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	// Metodo para agregar pedidos a un cliente
	public void agregarPedido(Pedido pedido) {
		if (pedidos == null) {
			pedidos = new ArrayList<>();
		}
		pedidos.add(pedido);
		pedido.setCliente(this);
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "direccion")
	private String direccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private DetalleCliente detalleCliente;
	
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Pedido> pedidos;
}
