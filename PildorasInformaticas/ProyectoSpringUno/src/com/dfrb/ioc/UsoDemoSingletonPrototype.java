package com.dfrb.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author danfe
 */

public class UsoDemoSingletonPrototype {
    public static void main(String[] args) {
        // Cargar el XML de configuracion
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_1.xml");
        
        // Peticion de los Beans al contenedor Spring
        SecretarioEmpleado secretario1 = context.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        SecretarioEmpleado secretario2 = context.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        SecretarioEmpleado secretario3 = context.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        SecretarioEmpleado secretario4 = context.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        SecretarioEmpleado secretario5 = context.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        
        // Imprimiendo los Beans
        System.out.println(secretario1);
        System.out.println(secretario2);
        System.out.println(secretario3);
        System.out.println(secretario4);
        System.out.println(secretario5);
        if (secretario1 == secretario2) {
            System.out.println("Apuntan al mismo objeto.");
        } else {
            System.out.println("Se trata de dos objetos distintos.");
        }
    }
}
