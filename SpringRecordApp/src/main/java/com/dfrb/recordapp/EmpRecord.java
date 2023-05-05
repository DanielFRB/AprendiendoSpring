package com.dfrb.recordapp;

/**
 * @author dfrb@ne
 */

public record EmpRecord(String nombres, String apellidos, String email) {
    // Constructor compacto
    public EmpRecord {
        if (email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacio");
        }
    }
}
