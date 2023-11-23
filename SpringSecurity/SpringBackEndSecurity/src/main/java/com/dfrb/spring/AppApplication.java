package com.dfrb.spring;

import com.dfrb.spring.entities.*;
import com.dfrb.spring.repository.UserDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppApplication {
    public static void main(String[] args) {
	SpringApplication.run(AppApplication.class, args);
    }
    
    @PostConstruct
    protected void init() {
        List<Authority> listaAutorizaciones = new ArrayList<>();
        listaAutorizaciones.add(crearAutorizacion("USER","User role"));
        listaAutorizaciones.add(crearAutorizacion("ADMIN","Admin role"));
        User usuario = new User();
        usuario.setUserName("danielfrb");
        usuario.setFirstName("Daniel");
        usuario.setLastName("Rondón");
        usuario.setPassword(encoder.encode("dfrb2703"));
        usuario.setEmail("danfelrondon@gmail.com");
        usuario.setEnabled(true);
        usuario.setAuthorities(listaAutorizaciones);
        userDetailsRepository.save(usuario);
    }
    
    private Authority crearAutorizacion(String roleCode, String roleDescription) {
        Authority autorizacion = new Authority();
        autorizacion.setRoleCode(roleCode);
        autorizacion.setRoleDescription(roleDescription);
        return autorizacion;
    }
    
    // Inyeccion de dependencias
    @Autowired
    private PasswordEncoder encoder;
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;
}
