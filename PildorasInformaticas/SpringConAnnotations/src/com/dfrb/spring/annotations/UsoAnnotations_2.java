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
        System.out.println("------------------------");
        
        // Pedir el 2do Bean
        Empleados empleado1 = miContexto.getBean("directorFinanciero", Empleados.class);
        System.out.println(empleado1.getTareas());
        System.out.println(empleado1.getInformes());
        System.out.println("------------------------");
        
        // Para acceder a los campos de clase de DirectorFinanciero no nos sirve la llamada del Bean anterior que se basa en llamar
        // objetos de tipo Empleado, si bien DirectorFinanciero implementa Empleados, los campos de clase estan es en la Clase
        // DirectorFinanciero, por lo que debe pedirse a esta ultima Clase
        DirectorFinanciero director = miContexto.getBean("directorFinanciero", DirectorFinanciero.class);
        System.out.println("Email del Director: "+ director.getEmail());
        System.out.println("Nombre de la Empresa: "+ director.getNombreEmpresa());
        
        // Cerrar el contexto
        miContexto.close();
    }
}
