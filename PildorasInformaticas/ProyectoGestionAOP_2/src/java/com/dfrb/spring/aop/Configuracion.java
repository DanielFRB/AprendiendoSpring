package com.dfrb.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.dfrb.spring")
public class Configuracion {
    
}
