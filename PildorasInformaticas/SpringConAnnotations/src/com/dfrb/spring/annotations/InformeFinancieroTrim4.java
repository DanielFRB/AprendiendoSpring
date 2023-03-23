package com.dfrb.spring.annotations;

import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class InformeFinancieroTrim4 implements CreacionInformeFinanciero {
	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion de informe de cierre de año";
	}
}
