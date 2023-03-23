package com.dfrb.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

// Se crea la Java Annotations @Component y el contenedor Spring registra el Bean con el nombre de "ComercialExperimentado"
// Por regla general la anotacion @Component no lleva un nombre explicito, en estos casos Spring registra el Bean con el
// nombre de la Clase.

@Component
// Para poder trabajar con el ciclo de vida del Bean es necesario que el Patron de Diseño del Bean sea de tipo Singleton
// por lo que se debe eliminar o comentar la anotacion @Scope
// @Scope("prototype") -- Java Annotation que permite trabajar con los patrones Singleton y Prototype, por defecto es Singleton
public class ComercialExperimentado implements Empleados {
	// Ejecucion de codigo despues de creado el Bean
	@PostConstruct // Sustituye al metodo init()
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutado despues de creado el Bean");
	}
	
	// Ejecucion de codigo despues de apagado el contenedor Spring
	@PreDestroy // Sustituye al metodo destroy()
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutando antes de la destruccion del Bean");
	}
	
	/* Spring nos permite hacer la inyeccion de dependencias de varias formas, la primera forma es mediante un Constructor
	que recibe su correspondiente parametro a inyectar. La segunda forma es mediante un metodo de tipo Setter que al igual
	que el Constructor reciba el parametro a inyectar. La tercera forma es por medio de un Campo de Clase en la que se aplica 
	internamente el concepto de Java que se denomina "Reflexion" que permite hacer la Inyeccion de la Dependencia. 
    
    1. Inyeccion de Dependencia mediante Constructor
	 @Autowired
    public ComercialExperimentado(CreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }
    
    2. Inyeccion de Dependencia mediante Metodo Setter
	@Autowired
    public void setInformeFinanciero(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}
	
	3. Inyeccion de Dependencia mediante Campo de Clase */
	@Autowired
	@Qualifier("informeFinancieroTrim2") // Uso de la anotacion @Qualifier para identificar el Bean Id que Spring va a inyectar
    private CreacionInformeFinanciero informeFinanciero;

	@Override
    public String getTareas() {
        return "Vender, vender y vender mas!!!";
    }

    @Override
    public String getInformes() {
        //return "Informe generado por el comercial";
        return informeFinanciero.getInformeFinanciero();
    }
}
