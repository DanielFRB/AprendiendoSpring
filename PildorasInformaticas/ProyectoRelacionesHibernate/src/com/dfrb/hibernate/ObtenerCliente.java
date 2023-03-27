package com.dfrb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class ObtenerCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		try {
			// Se comienza con la transaccion
			session.beginTransaction();

			// Se obtienen los detalles del cliente
			DetalleCliente detalleCliente = session.get(DetalleCliente.class, 2);
			if (detalleCliente != null) {
				System.out.println(detalleCliente.toString());
				// Obtiene al cliente
				System.out.println(detalleCliente.getCliente().toString());
				// Hacer el commit
				session.getTransaction().commit();
			} else {
				System.out.println("Cliente NO encontrado en la BBDD");
			}
		} finally {
			session.close();
			factory.close();
		}
	}
}
