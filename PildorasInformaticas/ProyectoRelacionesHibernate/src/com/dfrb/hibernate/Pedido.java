package com.dfrb.hibernate;

import java.util.*;

import javax.persistence.*;

/**
 * @author dfrb@ne
 */

@Entity
@Table(name = "pedido")
public class Pedido {
	public Pedido() {
	}

	public Pedido(GregorianCalendar fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaPago=" + fechaPago + ", formaPago=" + formaPago + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fecha_pago")
	private GregorianCalendar fechaPago;
	
	@Column(name = "forma_pago")
	private String formaPago;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}
