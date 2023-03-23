package com.dfrb.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dfrb@ne
 */

public class UsoAnnotations_2 {
    public static void main(String[] args) {
    	// Leer el XML de configuracion
        // ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	// Leer archivo java de configuracion
        AnnotationConfigApplicationContext miContexto = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
        
        // Pedir el Bean
        Empleados empleado = miContexto.getBean("comercialExperimentado", Empleados.class);
        
        // Usar el Bean
        System.out.println(empleado.getTareas());
        System.out.println(empleado.getInformes());
        
        // Cerrar el contexto
        miContexto.close();
    }
}