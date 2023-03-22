package com.dfrb.spring.annotations;

import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class InformeFinancieroTrim1 implements CreacionInformeFinanciero {
    @Override
    public String getInformeFinanciero() {
        return "Presentacion de informe financiero del trimestre 1";
    }
}
