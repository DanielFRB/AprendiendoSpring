package com.dfrb.spring.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Aspect
@Component
@Order(1)
public class RequisitosNuevoCliente {
    @Before("com.dfrb.spring.aspectos.LoginConAspecto.paraClientes()")
    public void requisitosCliente() {
        System.out.println("El nuevo Cliente cumple con los requisitos para ser insertado en la BBDD");
    }
}
