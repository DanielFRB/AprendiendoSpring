package com.dfrb.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author dfrb@ne
 */

public class ObtenerPedidosCliente_2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Cliente.class)
													.addAnnotatedClass(DetalleCliente.class)
													.addAnnotatedClass(Pedido.class)
													.buildSessionFactory();

		Session session = factory.openSession();
		try {
			String hql = "FROM Cliente c JOIN FETCH c.pedidos WHERE c.id = :clienteId";
			Query<Cliente> consulta = session.createQuery(hql);
			consulta.setParameter("clienteId", 1);
			Cliente cliente = (Cliente) consulta.getSingleResult();
			System.out.println("Cliente: "+ cliente);
			
			// Cierre de Sesion
			session.close();
			
			// Imprimir los Pedidos por Cliente despues de cierre se sesion
			for (Pedido p: cliente.getPedidos()) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
