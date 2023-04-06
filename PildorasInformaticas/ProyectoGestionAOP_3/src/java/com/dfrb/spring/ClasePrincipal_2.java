package com.dfrb.spring;

import com.dfrb.spring.aop.Configuracion;
import com.dfrb.spring.servicios.MedicionServicio;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dfrb@ne
 */

public class ClasePrincipal_2 {
    public static void main(String[] args) {
        // Leer la confoguracion de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
        
        // Obtener el Bean del contenedor de Spring
        MedicionServicio servicio = context.getBean("medicionServicio", MedicionServicio.class);
        System.out.println("Llamando al método getServicio()");
        String datos = servicio.getServicio();
        System.out.println("Datos devueltos por el método: "+ datos);
        
        // Cerrar el Contexto
        context.close();
    }
}
