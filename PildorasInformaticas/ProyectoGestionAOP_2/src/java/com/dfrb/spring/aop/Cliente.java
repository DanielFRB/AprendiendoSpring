package com.dfrb.spring.aop;

/**
 * @author dfrb@ne
 */

public class Cliente {
    public Cliente() {
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
    
    private String nombre;
    private String tipo;
}
