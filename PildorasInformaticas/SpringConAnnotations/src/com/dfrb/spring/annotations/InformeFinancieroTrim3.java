package com.dfrb.spring.annotations;

import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class InformeFinancieroTrim3 implements CreacionInformeFinanciero {
	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion de informe favorable del trimestre 3";
	}
}
