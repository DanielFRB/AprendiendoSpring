package com.dfrb.ioc;

/**
 * @author dfrb@ne
 */

public class JefeEmpleado implements Empleados {
    // Creacion del Contructor que recibe un parametro  de tipo CreacionInforme donde se inyecta la dependencia (informeNuevo)
    public JefeEmpleado(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }
    
    @Override
    public String getTareas() {
        return "Gestiono a mis Empleados";
    }
    
    @Override
    public String getInforme() {
        return "Informe presentado por el Jefe con arreglos: "+ informeNuevo.getInforme(); // Se inyecta el metodo getInforme() de la Clase Informe
    }
    
    // Creacion de campo tipo CreacionInforme (Interface)
    private CreacionInformes informeNuevo;
}
