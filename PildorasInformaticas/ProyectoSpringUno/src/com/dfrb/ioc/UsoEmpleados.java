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
        
        // 2do Paso: Pedir al archivo XML el Bean por medio de la Interface Empleados
        Empleados Oswaldo = miContexto.getBean("miDirectorEmp", Empleados.class);
        Empleados Yaneth = miContexto.getBean("miJefeEmp", Empleados.class);
        
        // Para poder tener acceso a las variables privadas de la Clase SecretarioEmpleado, es necesario cambiar
        // la forma en que se llama al Bean miSecretarioEmpleado, cambiando la forma como se pide el Bean a Spring
        // de Empleados a SecretarioEmpleado.
        // Empleados Daniel = miContexto.getBean("miSecretarioEmp", Empleados.class);
        SecretarioEmpleado Daniel = miContexto.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        SecretarioEmpleado Carlos = miContexto.getBean("miSecretarioEmp", SecretarioEmpleado.class);
        DirectorEmpleado Barack = miContexto.getBean("miDirectorEmp", DirectorEmpleado.class);
        // 3er Paso: Imprimir los Objetos creados.
        System.out.println(Oswaldo.getTareas());
        System.out.println(Yaneth.getTareas());
        System.out.println(Daniel.getTareas());
        System.out.println("----------------------------------------");
        
        // 4to Paso en la Inyeccion de Dependencias
        // El objeto Oswaldo utiliza la Inyeccion de Dependencias para ejecutar el metodo getInforme()
        System.out.println(Oswaldo.getInforme());
        // El objeto Yaneth utiliza la Inyeccion de Dependencias para ejecutar el metodo getInforme()
        System.out.println(Yaneth.getInforme());
        // El objeto Daniel utiliza la Inyeccion de Dependencias para ejecutar el metodo getInforme()
        System.out.println(Daniel.getInforme());
        System.out.println("----------------------------------------");
        System.out.println("Inyeccion de Campos de Dependencia a Objetos de tipo SecretarioEmpleado");
        System.out.println("Objeto Daniel - Email: "+ Daniel.getEmail());
        System.out.println("Objeto Daniel - Empresa: "+ Daniel.getNombreEmpresa());
        System.out.println("Objeto Carlos - Email: "+ Carlos.getEmail());
        System.out.println("Objeto Carlos - Empresa: "+ Carlos.getNombreEmpresa());
        System.out.println("----------------------------------------");
        System.out.println("Inyeccion de Campos de Dependencia a Objetos de tipo DirectorEmpleado");
        System.out.println("Objeto Barack - Email: "+ Barack.getEmail());
        System.out.println("Objeto Barack - Empresa: "+ Barack.getNombreEmpresa());
        
        // 4to Paso: Cerrar el Contexto para liberar recursos.
        miContexto.close();
    }
}
