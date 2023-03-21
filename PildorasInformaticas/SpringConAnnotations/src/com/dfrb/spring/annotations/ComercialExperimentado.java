package com.dfrb.spring.annotations;

import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

// Se crea la Java Annotations @Component y el contenedor Spring registra el Bean con el nombre de "ComercialExperimentado"
@Component("ComercialExperimentado")
public class ComercialExperimentado implements Empleados {
    @Override
    public String getTareas() {
        return "Vender, vender y vender mas!!!";
    }

    @Override
    public String getInformes() {
        return "Informe generado por el comercial";
    }
    
}
