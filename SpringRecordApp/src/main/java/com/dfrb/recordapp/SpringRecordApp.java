package com.dfrb.recordapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRecordApp {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Daniel", "Rondón", "danfelrondon@gmail.com");
        System.out.println(empleado);
        System.out.println(empleado.getApellidos()); // Se obtiene el valor del campo apellido por medio del getter
        EmpRecord emp = new EmpRecord("Yaneth", "Machado", "yanethmachado@gmail.com");
        System.out.println(emp);
        System.out.println(emp.apellidos()); // Se obtiene el valor del parametro apellido sin definir un getter
	SpringApplication.run(SpringRecordApp.class, args);
    }
}
