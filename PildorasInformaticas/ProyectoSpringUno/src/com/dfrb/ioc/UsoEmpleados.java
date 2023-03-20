package com.dfrb.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dfrb@ne
 */

// Aqui se utiliza la Inversion de Control de Spring al utilizar los Beans creados en el archivo applicationContext.xml
public class UsoEmpleados {
    public static void main(String[] args) {
        // 1er Paso: Cargar el Contexto de la aplicacion (El archivo applicationContext.xml)
        ClassPathXmlApplicationContext miContexto = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2do Paso: Pedir al archivo XML el Bean
        Empleados Oswaldo = miContexto.getBean("miDirectorEmp", Empleados.class);
        Empleados Yaneth = miContexto.getBean("miJefeEmp", Empleados.class);
        Empleados Daniel = miContexto.getBean("miSecretarioEmp", Empleados.class);
        // 3er Paso: Imprimir los Objetos creados.
        System.out.println(Oswaldo.getTareas());
        System.out.println(Yaneth.getTareas());
        System.out.println(Daniel.getTareas());
        // 4to Paso: Cerrar el Contexto para liberar recursos.
        miContexto.close();
    }
}
