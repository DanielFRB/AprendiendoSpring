package com.dfrb.spring.dao;

import com.dfrb.spring.aop.Cliente;
import java.util.*;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class ClienteDAOImplement {
    public void insertaCliente(Cliente cliente) {
        System.out.println("Se a agregado un nuevo Cliente a la BBDD");
    }
    
    public List<Cliente> getClientesList(boolean condicion) {
        if (condicion) throw new RuntimeException("No se ha encontrado la BBDD");
        
        List<Cliente> listaClientes = new ArrayList<>();
        
        // Simular los Clientes desde la BBDD.
        Cliente clt1 = new Cliente("Daniel Rondón", "V.I.P.");
        Cliente clt2 = new Cliente("Juan Romero", "Normal");
        Cliente clt3 = new Cliente("Gabriel Rondón", "V.I.P.");
        Cliente clt4 = new Cliente("Carlos Barboza", "Normal");
        Cliente clt5 = new Cliente("Javier Bracho", "Normal");
        
        // Agregar los Clientes a la Lista
        listaClientes.add(clt1);
        listaClientes.add(clt2);
        listaClientes.add(clt3);
        listaClientes.add(clt4);
        listaClientes.add(clt5);
        
        System.out.println("Finalizando proceso getListaClientes()");
        
        // Retornar la Lista de Clientes
        return listaClientes;
    }
}
