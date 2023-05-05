package com.dfrb.spring.entities;

/**
 * @author dfrb@ne
 */

public class Empleado {
    public Empleado() {
    }

    public Empleado(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    // Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Campos de Clase
    private String nombres;
    private String apellidos;
}
