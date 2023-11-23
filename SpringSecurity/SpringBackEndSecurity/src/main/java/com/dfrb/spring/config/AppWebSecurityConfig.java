package com.dfrb.spring.config;

import com.dfrb.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
        http.httpBasic(); // Configura Autorizacion Básica HTTP */
        
        // http.authorizeRequests((request) -> request.antMatchers("h2-console/**").permitAll().anyRequest().authenticated()).httpBasic();
        // http.formLogin();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .authorizeHttpRequests((request) -> request.antMatchers("/h2-console/**", "/api/v1/auth/login").permitAll()
						.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
                .addFilterBefore(new JWTAuthenticationFilter(userServices, jwtTokenHelper), UsernamePasswordAuthenticationFilter.class);
        
        // Consola h2
        http.csrf().disable().cors().and().headers().frameOptions().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Autenticacion inMemory
        // auth.inMemoryAuthentication().withUser("Daniel").password(passwordEncoder().encode("test@123"))
	//			.authorities("USER", "ADMIN");
        
        // Autenticacion por BBDD utilizando UserServices
        auth.userDetailsService(userServices).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    // Inyeccion del Servicio de Usuario
    @Autowired
    private UserServices userServices;
    
    // Inyeccion del Componente que nos permite manejar el Token JWT
    @Autowired
    private JWTTokenHelper jwtTokenHelper;
    
    // Inyeccion de la Interface que permite initiar el esquema de autenticacion
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;  
}
