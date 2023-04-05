package com.dfrb.spring.aspectos;

import com.dfrb.spring.aop.Cliente;
import org.aspectj.lang.JoinPoint;
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
    // Se crea un JoinPont para poder acceder a los parametros del metodo especificado en el Pointcut si el metodo contiene alguno
    public void antesInsertarCliente(JoinPoint point) {
        System.out.println("El usuario esta logueado correctamente");
        System.out.println("El perfil del usuario para Insertar Cliente es correcto");
        Object[] parametros = point.getArgs();
        for (Object p : parametros) {
            if (p instanceof Cliente) {
                Cliente cliente = (Cliente) p;
                System.out.println("El nombre del Cliente es: "+ cliente.getNombre());
                System.out.println("El tipo de Cliente es: "+ cliente.getTipo());
            }
        }
        
    }
}
