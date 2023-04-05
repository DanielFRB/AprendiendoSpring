package com.dfrb.spring.aop;

/**
 * @author dfrb@ne
 */

public class Cliente {
    public Cliente() {
    }

    public Cliente(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
    private String nombre;
    private String tipo;
}
