package com.dfrb.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Código momentáneo mientras creamos la BBDD
        UserBuilder usuario = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(usuario.username("Daniel").password("1234").roles("EMPLO"))
                .withUser(usuario.username("Yaneth").password("4567").roles("ADMIN"))
                .withUser(usuario.username("Oswaldo").password("7890").roles("EMPLO"))
                .withUser(usuario.username("Barack").password("0123").roles("ADMIN"));
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin()
                .loginPage("/formLogin")
                .loginProcessingUrl("/userAuthentication")
                .permitAll()
                .and().logout() // Usuarios pueden cerrar sesión
                .permitAll();
    }
}
