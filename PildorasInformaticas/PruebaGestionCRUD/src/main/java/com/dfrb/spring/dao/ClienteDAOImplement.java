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
    
    @Override
    @Transactional
    public void insertarCliente(Cliente cliente) {
        // Obtener la sesion
	Session session = sessionFactory.getCurrentSession();
        
        // Insertar el Cliente en la BBDD
        // session.save(cliente); Insert Into
        session.saveOrUpdate(cliente);
    }

    @Override
    @Transactional
    public Cliente getCliente(int id) {
        // Obtener la sesion
        Session session = sessionFactory.getCurrentSession();
        
        // Crear el Objeto Cliente
        Cliente cliente = session.get(Cliente.class, id);
        
        // Retornar el Cliente
        return cliente;
    }

    @Override
    @Transactional
    public void deleteCliente(int id) {
        // Obtener la sesion
        Session session = sessionFactory.getCurrentSession();
        
        // Crear la Instruccion HQL
        String hql = "DELETE FROM Cliente c WHERE c.id=:id";
        Query query = session.createQuery(hql);
        
        // Establecer el Parametro de la Instruccion HQL
        query.setParameter("id", id);
        
        // Ejecutar la Consulta
        query.executeUpdate();
    }
    
    @Autowired
    private SessionFactory sessionFactory;
}
