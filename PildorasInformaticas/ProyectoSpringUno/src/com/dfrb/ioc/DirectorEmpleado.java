package com.dfrb.ioc;

/**
 * @author dfrb@ne
 */

public class DirectorEmpleado implements Empleados {
    // Continuacion 2do Paso: Creacion del Contructor que recibe un parametro de tipo CreacionInforme donde se
    // inyecta la dependencia (informeNuevo)
    public DirectorEmpleado(CreacionInformes informeNuevo) {
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
        return "Gestionar la Plantilla de la Empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Director: "+ informeNuevo.getInforme(); // Se inyecta el metodo getInforme() de la Clase Informe
    }
    
    // Metodo init(). Ejecuta tareas antes de que el Bean este disponible
    public void metodoInicial() {
        System.out.println("Metodo Init, dentro van las tareas que se ejecutan antes de usar el bean");
    }
    
    // Metodo destroy(). Ejecuta tareas despues de que el Bean haya sido utilizado
    public void metodoFinal() {
        System.out.println("Metodo Destroy, dentro van las tareas que se ejecutan despues de usar el bean");
    }
    
    // 2do Paso: Creacion de campo tipo CreacionInforme (Interface)
    private CreacionInformes informeNuevo;
    
    // Creacion de campos para Inyeccion de Campos con Spring
    private String email;
    private String nombreEmpresa;
}
