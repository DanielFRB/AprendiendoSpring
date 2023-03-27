package com.dfrb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author dfrb@ne
 */

public class PruebaEliminaClienteHQL {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			String hql = "DELETE FROM Clientes WHERE direccion = :direccion";
			session.createQuery(hql).setParameter("direccion", "La Plata - Argentina").executeUpdate();
			System.out.println("Registros eliminados con Exito!!!");
			// Hacer el commit
			session.getTransaction().commit();
			
			// Cierre de la Sesion para liberar recursos
			session.close();
		} finally {
			factory.close();
		}
	}

}
