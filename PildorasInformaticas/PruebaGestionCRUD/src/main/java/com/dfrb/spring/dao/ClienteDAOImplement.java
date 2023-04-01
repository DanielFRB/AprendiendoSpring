package com.dfrb.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dfrb.spring.entidad.Cliente;

/**
 * @author dfrb@ne
 */

@Repository
public class ClienteDAOImplement implements ClienteDAO {
    @Override
    @Transactional
    public List<Cliente> getClientes() {
	// Obtener la sesion
	Session session = sessionFactory.getCurrentSession();
		
	// Crear la Consulta
	String hql = "FROM Cliente c"; 
	Query<Cliente> consultaClientes = session.createQuery(hql, Cliente.class);
		
	// Ejecutar la Consulta y devolver los resultados
	List<Cliente> clientes = consultaClientes.getResultList();
	return clientes;
    }
	
    @Autowired
    private SessionFactory sessionFactory;
}
