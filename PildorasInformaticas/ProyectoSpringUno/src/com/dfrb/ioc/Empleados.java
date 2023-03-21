package com.dfrb.ioc;

/**
  * @author dfrb@ne
 */

public interface Empleados {
    public String getTareas();
    // 2do Paso: Agregando metodo getInforme(). Esto origina que las clases que implelenten esta interface tengan que
    // desarrollar este nuevo metodo.
    public String getInforme();
}
