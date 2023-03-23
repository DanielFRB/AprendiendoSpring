package com.dfrb.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author dfrb@ne
 */

@Configuration
@ComponentScan("com.dfrb.spring.annotations")
@PropertySource("classpath:datosEmpresa.properties")
public class EmpleadosConfig {
	// Definir el Bean para InformeFinancieroDptocompras
	@Bean
	public CreacionInformeFinanciero informeFinancieroDptoCompras() { // Sera el Id del Bean inyectado
		return new InformeFinancieroDptoCompras();
	}
	
	// Defin ir el Bean para DirectorFinanciero e Inyectar la Dependencia
	@Bean
	public Empleados directorFinanciero() {
		return new DirectorFinanciero(informeFinancieroDptoCompras());
	}
}
