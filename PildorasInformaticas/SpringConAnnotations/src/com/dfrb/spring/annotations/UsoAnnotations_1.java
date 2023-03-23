package com.dfrb.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dfrb@ne
 */

public class UsoAnnotations_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Leer el XML de configuracion
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Pedir el bean al contenedor
        Empleados Daniel = miContexto.getBean("comercialExperimentado", Empleados.class);
        Empleados Yaneth = miContexto.getBean("comercialExperimentado", Empleados.class);
        if (Daniel == Yaneth) {
        	System.out.println("Apuntan al mismo objeto en memoria");
        	System.out.println(Daniel +"\n"+ Yaneth);
        } else {
        	System.out.println("No apuntan al mismo objeto en memoria");
        	System.out.println(Daniel +"\n"+ Yaneth);
        }
        
        // Cerrar el contexto
        miContexto.close();
	}
}
