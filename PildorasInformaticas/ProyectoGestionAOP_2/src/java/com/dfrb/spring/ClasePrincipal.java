package com.dfrb.spring;

import com.dfrb.spring.aop.Cliente;
import com.dfrb.spring.aop.Configuracion;
import com.dfrb.spring.dao.ClienteDAOImplement;
import com.dfrb.spring.dao.ClienteVIPDAOImplement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dfrb@ne
 */

public class ClasePrincipal {
    public static void main(String[] args) {
        // Leer la confoguracion de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
        // Obtener el Bean del contenedor de Spring
        Cliente clt = new Cliente();
        clt.setNombre("Daniel Rondón");
        clt.setTipo("Cliente Normal");
        ClienteDAOImplement cliente = context.getBean("clienteDAOImplement", ClienteDAOImplement.class);
        ClienteVIPDAOImplement clientevip = context.getBean("clienteVIPDAOImplement", ClienteVIPDAOImplement.class);
        // Llamar al metodo
        cliente.insertaCliente(clt);
        System.out.println("------------------------");
        clientevip.insertaClienteVIP(); // Por medio del Pointcut se puede ejecutar el aspecto sobre este metodo tambien
        // Cerrar el Contexto
        context.close();
    }
}
