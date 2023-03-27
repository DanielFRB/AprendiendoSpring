package com.dfrb.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class InsertaCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Cliente.class)
													.addAnnotatedClass(DetalleCliente.class)
													.buildSessionFactory();
		
		Session session = factory.openSession();
		try {
			Cliente cliente = new Cliente("Daniel Felipe", "Rondon Barboza", "Guanare");
			DetalleCliente detalleCliente = new DetalleCliente("www.danielfelipe.com", "+584145259638", "Aprendiendo Spring...");
			
			// Asosiar los objetos por medio del metodo Setter
			cliente.setDetalleCliente(detalleCliente);
			
			// Se guarda la informacion en las dos tablas
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			
			// Hacer el commit
			session.getTransaction().commit();
			
			// Cierre de la Sesion para liberar recursos
			session.close();
		} finally {
			factory.close();
		}
	}
}
