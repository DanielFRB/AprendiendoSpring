package com.dfrb.springsecurity.config;

import com.sun.source.util.TaskEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Modo configuracion 1
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/v1/index2").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .build();
    }
    
    /* @Bean
    public SecurityFilterChain chain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(fl -> {
                    fl.successHandler(handler());
                    fl.permitAll();
                })
                .sessionManagement(sm -> {
                    sm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
                    sm.invalidSessionUrl("/login");
                    sm.maximumSessions(1)
                            .expiredUrl("/login")
                            .sessionRegistry(sessionRegistry());
                    sm.sessionFixation()
                            .migrateSession();
                })
                .build();
    } */
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    
    public AuthenticationSuccessHandler handler() {
        return ((request, response, authenticacion) -> {
            response.sendRedirect("/v1/session");
        });
    }
}
