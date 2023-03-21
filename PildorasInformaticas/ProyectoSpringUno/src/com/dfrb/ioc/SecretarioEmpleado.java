package com.dfrb.ioc;

/**
 * @author dfrb@ne
 */

public class SecretarioEmpleado implements Empleados {
    // Creacion de metodo Setter donde se realiza la Inyeccion de Dependencias
    public void setInformeNuevo(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }
    
    @Override
    public String getTareas() {
        return "Gestionar la Agenda de los Jefes";
    }
    
    @Override
    public String getInforme() {
        return "Informe generado por el Secretario: "+ informeNuevo.getInforme(); // Se inyecta el metodo getInforme() de la Clase Informe
    }
    
    // Creacion de campo tipo CreacionInforme (Interface)
    private CreacionInformes informeNuevo;
}
