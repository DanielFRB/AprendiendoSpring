package com.dfrb.spring.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Aspect
@Component
@Order(2)
public class LoginConAspecto {
    @Pointcut("execution(* insertaCliente*(..))") // Aplicando un Pointcut expression (*) al inicio y al final del nombre del metodo
    public void paraClientes() {
    }
    
    @Before("paraClientes()")
    public void antesInsertarCliente() {
        System.out.println("El usuario esta logueado correctamente");
        System.out.println("El perfil del usuario para Insertar Cliente es correcto");
    }
}
