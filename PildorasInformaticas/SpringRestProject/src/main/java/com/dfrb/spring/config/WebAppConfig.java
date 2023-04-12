package com.dfrb.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dfrb.spring")
public class WebAppConfig {

}
