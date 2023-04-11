package com.dfrb.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author dfrb@ne
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Empleado {
    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public DatosEmpleado getDatos_registro() {
        return datos_registro;
    }

    public void setDatos_registro(DatosEmpleado datos_registro) {
        this.datos_registro = datos_registro;
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", activo=" + activo + '}';
    }
    
    private int id;
    private String nombre;
    private String apellido;
    private boolean activo;
    private String[] idiomas;
    private DatosEmpleado datos_registro;
}
