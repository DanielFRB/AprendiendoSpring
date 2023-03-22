package com.dfrb.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dfrb@ne
 */

public class UsoAnnotations {
    public static void main(String[] args) {
        // Leer el XML de configuracion
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Pedir el bean al contenedor
        // Debido al cambio en la anotacion @Component de la Clase ComercialExperimentado de debe cambiar
        // el nombre de llamada del Bean
        Empleados Daniel = miContexto.getBean("comercialExperimentado", Empleados.class);
        
        // Usar el Bean
        System.out.println(Daniel.getTareas());
        System.out.println(Daniel.getInformes());
        
        // Cerrar el contexto
        miContexto.close();
    }
}
