package com.dfrb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PruebaGuardaCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Clientes clt1 = new Clientes("Daniel", "Machado", "Guanare");
			session.beginTransaction();
			session.save(clt1);
			session.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			session.close();
		} finally {
			factory.close();
		}
	}

}
