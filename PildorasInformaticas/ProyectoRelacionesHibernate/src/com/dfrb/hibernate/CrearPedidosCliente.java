package com.dfrb.hibernate;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author dfrb@ne
 */

public class CrearPedidosCliente {
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
			Cliente cliente = session.get(Cliente.class, 4);
			
			// Crear Pedidos del Cliente;
			Pedido ped1 = new Pedido(new GregorianCalendar(2021, 6, 4));
			Pedido ped2 = new Pedido(new GregorianCalendar(2020, 3, 14));
			Pedido ped3 = new Pedido(new GregorianCalendar(2019, 7, 24));
			
			// Agregar Pedidos al Cliente
			cliente.agregarPedido(ped1);
			cliente.agregarPedido(ped2);
			cliente.agregarPedido(ped3);
			
			// Guardar los Pedidoa a la BBDD
			session.save(ped1);
			session.save(ped2);
			session.save(ped3);
			
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
