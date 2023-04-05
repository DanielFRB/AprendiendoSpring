package com.dfrb.spring.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Aspect
@Component
public class LoginConAspecto {
    // Reutilizacion de Pointcuts
    // Esta reutilizacion nos sirve para facilitar el uso se los pointcuts, ya que si tenemos que hacer una modificacion
    // en la regla de validacion, solo se deba hacer en un solo sitio y el resto de los metodos realizara las nuevas tareas
    // de acuerdo a la nueva regla 
    @Pointcut("execution(* insertaCliente(..))") // Aplicando un Pointcut expression (*) al inicio y al final del nombre del metodo
    private void paraClientes() {
    }
    
    // Colocando dos puntos dentro de los parentesis del metodo le indica al aspecto de debe trabajar tanto con metodos
    // que reciben parametros como con los que no lo reciben
    @Before("paraClientes()")
    public void antesInsertarCliente() {
        System.out.println("El usuario esta logueado correctamente");
        System.out.println("El perfil del usuario para Insertar Cliente es correcto");
    }
    
    @Before("paraClientes()")
    public void requisitosCliente() {
        System.out.println("El nuevo Cliente cumple con los requisitos para ser insertado en la BBDD");
    }
    
    @Before("paraClientes()")
    public void requisitosTabla() {
        System.out.println("Hay menos de 3000 registros en la Tabla Clientes, puedes insertar un nuevo registro");
    }
}
