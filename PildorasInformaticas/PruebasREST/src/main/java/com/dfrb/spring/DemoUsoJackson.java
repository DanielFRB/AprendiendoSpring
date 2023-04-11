package com.dfrb.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * @author dfrb@ne
 */

public class DemoUsoJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Empleado empleado = mapper.readValue(new File("data/datos_empleados.json"), Empleado.class);
            System.out.println("Nombre del Empleado: "+ empleado.getNombre());
            System.out.println("Apellido del Empleado: "+ empleado.getApellido());
            System.out.println("Idiomas que habla el Empleado: ");
            for (String idioma : empleado.getIdiomas()) {
                System.out.println("Habla: "+ idioma);
            }
            DatosEmpleado datosEmpleado = empleado.getDatos_registro();
            System.out.println("Domicilio del Empleado: "+ datosEmpleado.getDomicilio());
            System.out.println("Código Postal: "+ datosEmpleado.getCodigo_postal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
