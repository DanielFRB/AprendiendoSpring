package com.dfrb.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

/**
 * @author dfrb@ne
 */

public class ConsultaClientes {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			// Comenzar sesion
			session.beginTransaction();
			
			// Consulta de Clientes
			List<Clientes> clientes = session.createQuery("from Clientes").getResultList();
			recorreListaClientes(clientes);
			
			// Consultar por campo especifico
			clientes = session.createQuery("from Clientes C where C.apellidos = 'Machado'").getResultList();
			recorreListaClientes(clientes);
			
			// Consultar por dos o mas campos
			clientes = session.createQuery("from Clientes C where C.nombres = 'Barack' or C.direccion = 'La Plata - Argentina'").getResultList();
			recorreListaClientes(clientes);
			
			// Hacer el commit
			session.getTransaction().commit();
			
			// Cerrar sesion
			session.close();
		} finally {
			factory.close();
		}
	}

	private static void recorreListaClientes(List<Clientes> clientes) {
		for (Clientes c : clientes) {
			System.out.println(c.toString());
		}
	}
}
