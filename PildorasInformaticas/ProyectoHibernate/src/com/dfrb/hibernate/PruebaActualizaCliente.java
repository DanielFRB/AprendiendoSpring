package com.dfrb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class PruebaActualizaCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			int clienteId = 2;
			session.beginTransaction();
			Clientes cliente = session.get(Clientes.class, clienteId);
			cliente.setApellidos("Rondon");
			System.out.println("Registro actualizado correctamente en BBDD");
			// Hacer el commit
			session.getTransaction().commit();
			
			// Cierre de la Sesion para liberar recursos
			session.close();
		} finally {
			factory.close();
		}
	}

}
