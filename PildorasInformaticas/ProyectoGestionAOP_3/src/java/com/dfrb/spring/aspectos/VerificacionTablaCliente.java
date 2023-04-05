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
@Order(3)
public class VerificacionTablaCliente {
    @Before("com.dfrb.spring.aspectos.LoginConAspecto.paraClientes()")
    public void requisitosTabla() {
        System.out.println("Hay menos de 3000 registros en la Tabla Clientes, puedes insertar un nuevo registro");
    }
}
