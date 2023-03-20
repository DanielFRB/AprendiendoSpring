package com.dfrb.spring;

/**
 * @author dfrb@ne
 */

// En este ejemplo no se esta utilizando la Inversion de Control de Spring
public class UsoEmpleados {
    public static void main(String[] args) {
        // Creacion de objetos de tipo JefeEmpleado
        JefeEmpleado empleado = new JefeEmpleado();
        // Una vez creada la Interface Empleados, podemos hacer la abstraccion en la creacion de objetos, ya que JefeEmpleados implementa
        // la Interface Empleados.
        Empleados empleado1 = new JefeEmpleado();
        // Creacion de objeto de tipo SecretarioEmpleado. Para ello debemos construir una nueva clase SecretarioEmpleado que implemente
        // la Interface Empleados.
        Empleados empleado2 = new SecretarioEmpleado();
        // Creacion de objeto de tipo DirectorEmpleado. Para ello debemos construir una nueva clase DirectorEmpleado que implemente
        // la Interface Empleados.
        Empleados empleado3 = new DirectorEmpleado();
        
        System.out.println(empleado.getTareas());
        System.out.println(empleado1.getTareas());
        System.out.println(empleado2.getTareas());
        System.out.println(empleado3.getTareas());
    }
}
