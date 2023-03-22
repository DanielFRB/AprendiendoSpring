package com.dfrb.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

// Se crea la Java Annotations @Component y el contenedor Spring registra el Bean con el nombre de "ComercialExperimentado"
// Por regla general la anotacion @Component no lleva un nombre explicito, en estos casos Spring registra el Bean con el
// nombre de la Clase.

@Component
public class ComercialExperimentado implements Empleados {
    @Autowired
    public ComercialExperimentado(CreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }
    
    @Override
    public String getTareas() {
        return "Vender, vender y vender mas!!!";
    }

    @Override
    public String getInformes() {
        //return "Informe generado por el comercial";
        return informeFinanciero.getInformeFinanciero();
    }
    
    private CreacionInformeFinanciero informeFinanciero;
}
