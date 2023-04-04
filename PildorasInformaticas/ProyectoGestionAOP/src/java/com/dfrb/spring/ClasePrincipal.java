package com.dfrb.spring;

import com.dfrb.spring.aop.Configuracion;
import com.dfrb.spring.dao.ClienteDAOImplement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dfrb@ne
 */

public class ClasePrincipal {
    public static void main(String[] args) {
        // Leer la confoguracion de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
        // Obtener el Bean del contenedor de Spring
        ClienteDAOImplement cliente = context.getBean("clienteDAOImplement", ClienteDAOImplement.class);
        // Llamar al metodo
        cliente.insertaCliente();
        // Cerrar el Contexto
        context.close();
    }
}
