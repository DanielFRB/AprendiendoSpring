package com.dfrb.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class EliminaCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Cliente.class)
													.addAnnotatedClass(DetalleCliente.class)
													.buildSessionFactory();
		
		Session session = factory.openSession();
		try {
			// Se comienza con la transaccion
			session.beginTransaction();
			
			// Se obtiene el registro a ser eliminado
			Cliente cliente = session.get(Cliente.class, 4);
			if (cliente != null) {
				// Se elimina el registro cliente
				System.out.println("Eliminando al Cliente: "+ cliente.getNombres() +" "+ cliente.getApellidos() +"...");
				session.delete(cliente);
				System.out.println("Registro eliminado correctamente en BBDD");
				session.getTransaction().commit();
			} else {
				System.out.println("Cliente NO encontrado en la BBDD");
			}
			
			// Cierre de la Sesion para liberar recursos
			session.close();
		} finally {
			factory.close();
		}
	}
}
