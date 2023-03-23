package com.dfrb.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dfrb@ne
 */

public class DirectorFinanciero implements Empleados {
	@Autowired
	public DirectorFinanciero(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestion y direccion de las operaiones financiera de la Empresa";
	}

	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return informeFinanciero.getInformeFinanciero();
	}
	
	private CreacionInformeFinanciero informeFinanciero;
}
