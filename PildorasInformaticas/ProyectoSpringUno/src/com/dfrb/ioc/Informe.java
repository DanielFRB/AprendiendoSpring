package com.dfrb.ioc;


/**
 * @author danfe
 */

// Continuacion 1er Paso: Creacion de la Clase que implementa la Interface para la Dependencia.
public class Informe implements CreacionInformes {
    @Override
    public String getInforme() {
        return "Esta es la Presentacion del Informe.";
    }
}
