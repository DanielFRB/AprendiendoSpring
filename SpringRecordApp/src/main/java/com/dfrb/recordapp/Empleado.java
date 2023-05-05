package com.dfrb.recordapp;

import java.util.Objects;

/**
 * @author dfrb@ne
 */

public class Empleado {
    public Empleado(String nombres, String apellidos, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    // Getters
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, apellidos, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return nombres.equals(other.nombres) && apellidos.equals(other.apellidos) && email.equals(other.email);
    }
    
    
    @Override
    public String toString() {
        return "Empleado{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + '}';
    }
    
    // Al hacer final estos campos de Clase, el objeto creado se vuelve inmutable
    private final String nombres;
    private final String apellidos;
    private final String email;
}
