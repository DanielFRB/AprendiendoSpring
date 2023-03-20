package com.dfrb.spring;

/**
 * @author dfrb@ne
 */

public class SecretarioEmpleado implements Empleados {
    @Override
    public String getTareas() {
        return "Gestionar la Agenda de los Jefes";
    }
}
