package com.dfrb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PruebaGuardaCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Clientes clt1 = new Clientes("Barack", "Rondon Machado", "Guanare");
			session.beginTransaction();
			session.save(clt1);
			session.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			
			// Lectura de Registro
			session.beginTransaction();
			System.out.println("Lectura de registro con Id: "+ clt1.getId());
			Clientes cltRecuperado = session.get(Clientes.class, clt1.getId());
			System.out.println("Registro: "+ cltRecuperado.toString());
			session.getTransaction().commit();
			System.out.println("Terminado!!!");
			
			// Cierre de la Sesion para liberar recursos
			session.close();
		} finally {
			factory.close();
		}
	}

}
