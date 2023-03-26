package com.dfrb.spring.mvc.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodigoPostalMadridValidator implements ConstraintValidator<CodPostalMadrid, String> {
	@Override
    public void initialize(CodPostalMadrid cPostalMadrid) {
		prefigoCodMadrid = cPostalMadrid.value();
	}
	
	@Override
	public boolean isValid(String codigoPostal, ConstraintValidatorContext context) {
		boolean valueCodigo;
		if (codigoPostal != null) {
			valueCodigo = codigoPostal.startsWith(prefigoCodMadrid);
		} else {
			return valueCodigo = true;
		}
		
		return valueCodigo;
	}
	
	private String prefigoCodMadrid;
}
