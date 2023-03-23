package com.dfrb.spring.annotations;

import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Component
public class InformeFinancieroTrim2 implements CreacionInformeFinanciero {
	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion del informe catastrofico del trimestre 2";
	}
}
