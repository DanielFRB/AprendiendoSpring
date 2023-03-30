package com.dfrb.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class ObtenerPedidosCliente {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Cliente.class)
													.addAnnotatedClass(DetalleCliente.class)
													.addAnnotatedClass(Pedido.class)
													.buildSessionFactory();

		Session session = factory.openSession();
		try {
			session.beginTransaction();
			
			// Obtener el Cliente
			Cliente cliente = session.get(Cliente.class, 3);
			
			// Imprimir el Cliente
			System.out.println("Cliente: "+ cliente.toString());
			
			// Imprimir los Pedidos por Cliente
			for (Pedido p: cliente.getPedidos()) {
				System.out.println(p);
			}
			
			// Hacer el commit
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}
}
