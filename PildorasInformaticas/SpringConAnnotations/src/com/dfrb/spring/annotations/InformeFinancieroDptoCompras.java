package com.dfrb.spring.annotations;

/**
 * @author dfrb@ne
 */

public class InformeFinancieroDptoCompras implements CreacionInformeFinanciero {
	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Informe Financiero del Departamento de Compras del año 2022";
	}
}
