package com.dfrb.spring.mvc.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author dfrb@ne
 */

@Constraint(validatedBy = CodigoPostalMadridValidator.class) // Clase que contiene la logica de la Validacion
@Target({ElementType.METHOD, ElementType.FIELD}) // Destino de la Validacion (Metodos o Campos)
@Retention(RetentionPolicy.RUNTIME) // Chequea la Validacion en tiempo de ejecucion
public @interface CodPostalMadrid {
	// Se define el Codigo Postal por defecto
	public String value() default "28";
	
	// Definir el Mensaje de Error
	public String message() default "El Codigo Postal debe comenzar por 28";
	
	// Definir los grupos
	Class<?>[] groups() default {};
	
	// Definir los Payloads
	Class<? extends Payload>[] payload() default {};
}
