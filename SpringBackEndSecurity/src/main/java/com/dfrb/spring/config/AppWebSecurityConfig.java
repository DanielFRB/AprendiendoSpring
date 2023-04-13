package com.dfrb.spring.config;

import com.dfrb.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebSecurity
public class AppWebSecurityConfig extends WebSecurityConfigurerAdapter {
    // Se crea un Bean que nos permita codificar la contraseña del nuevo usuario
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().anyRequest().permitAll(); // Permite el acceso a todos sin pasar por ningun formulario de acceso
        /*  http.authorizeRequests().anyRequest().authenticated(); // Obliga a que el usuario sea autenticado
        http.formLogin(); // Coloca el formulario de acceso al inicio de la aplicación
        http.httpBasic(); // Configura Autorizacion Básica */
        
        http.authorizeRequests((request) -> request.antMatchers("h2-console/**").permitAll().anyRequest().authenticated()).httpBasic();
        http.formLogin();
        
        // Consola h2
        http.csrf().disable().headers().frameOptions().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Autenticacion por BBDD utilizando UserServices
        auth.userDetailsService(userServices).passwordEncoder(passwordEncoder());
    }
    
    // Inyeccion del Servicio
    @Autowired
    private UserServices userServices;
}
