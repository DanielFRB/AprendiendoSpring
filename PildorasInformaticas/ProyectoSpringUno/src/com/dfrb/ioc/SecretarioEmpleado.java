package com.dfrb.ioc;

/**
 * @author dfrb@ne
 */

public class SecretarioEmpleado implements Empleados {
    // Creacion de metodo Setter donde se realiza la Inyeccion de Dependencias
    public void setInformeNuevo(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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
    
    // Creacion de campos para Inyeccion de Campos con Spring
    private String email;
    private String nombreEmpresa;
}
