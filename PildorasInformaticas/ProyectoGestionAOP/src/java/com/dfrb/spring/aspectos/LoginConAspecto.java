package com.dfrb.spring.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Aspect
@Component
public class LoginConAspecto {
    @Before("execution(* insertaCliente*())") // Aplicando un Pointcut expression (*) al final del nombre del metodo
    public void antesInsertarCliente() {
        System.out.println("El usuario esta logueado correctamente");
        System.out.println("El perfil del usuario para Insertar Cliente es correcto");
    }
}
