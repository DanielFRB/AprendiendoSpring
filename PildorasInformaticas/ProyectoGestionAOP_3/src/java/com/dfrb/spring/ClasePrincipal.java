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
        boolean condicion = true;
        try {
            cliente.getClientesList(condicion);
        } catch(Exception e) {
            System.out.println("Excepcion lanzada desde el metodo getClientesList()");
            System.out.println(e.getMessage());
        }
        System.out.println("Continua la ejecucion del programa despues del metodo getClientesClist()...");
        
        // Cerrar el Contexto
        context.close();
    }
}
