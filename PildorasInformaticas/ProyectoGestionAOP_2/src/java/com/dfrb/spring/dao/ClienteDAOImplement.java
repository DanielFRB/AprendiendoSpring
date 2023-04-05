package com.dfrb.spring.dao;

import com.dfrb.spring.aop.Cliente;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class ClienteDAOImplement {
    public void insertaCliente(Cliente cliente) {
        System.out.println("Se a agregado un nuevo Cliente a la BBDD");
    }
}
