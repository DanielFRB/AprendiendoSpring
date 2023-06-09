package com.dfrb.spring.dao;

import java.util.List;
import com.dfrb.spring.entidad.Cliente;

/**
 * @author dfrb@ne
 */

public interface ClienteDAO {
    public List<Cliente> getClientes();

    public void insertarCliente(Cliente cliente);

    public Cliente getCliente(int id);

    public void deleteCliente(int id);
}
