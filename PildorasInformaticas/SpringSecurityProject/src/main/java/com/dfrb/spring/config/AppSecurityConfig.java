package com.dfrb.spring.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Autenticacion de la Conexion con la BBDD por medio del metodo inyectado securityDataSource()
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated().and().formLogin()
        http.authorizeRequests().antMatchers("/").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/formLogin")
                .loginProcessingUrl("/userAuthentication")
                .permitAll()
                .and().logout() // Usuarios pueden cerrar sesión
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDenied"); // Configurando Página de error
    }
    
    @Autowired
    private DataSource securityDataSource; // Se inyecta el metodo configurado en el AppConfig
}
