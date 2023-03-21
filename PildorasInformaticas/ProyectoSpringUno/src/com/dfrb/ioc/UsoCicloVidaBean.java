package com.dfrb.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class UsoCicloVidaBean {
    public static void main(String[] args) {
        // Cargar el XML de configuracion
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_2.xml");
        
        // Peticion de los Beans al contenedor Spring
        Empleados Daniel = context.getBean("miDirectorEmp", Empleados.class);
        
        // Imprimiendo el Bean
        System.out.println(Daniel.getInforme());
        
        // Cerrar el contexto
        context.close();
    }
}
