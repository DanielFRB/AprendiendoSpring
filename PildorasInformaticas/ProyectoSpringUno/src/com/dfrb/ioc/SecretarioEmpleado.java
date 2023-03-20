package com.dfrb.ioc;

/**
 * @author dfrb@ne
 */

public class SecretarioEmpleado implements Empleados {
    @Override
    public String getTareas() {
        return "Gestionar la Agenda de los Jefes";
    }
}
