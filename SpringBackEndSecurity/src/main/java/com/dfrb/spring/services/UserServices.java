package com.dfrb.spring.services;

import com.dfrb.spring.entities.User;
import com.dfrb.spring.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dfrb@ne
 */

@Service
public class UserServices implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = userDetailsRepository.findByUserName(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre de: "+ username);
        }
        return usuario;
    }
    
    @Autowired
    UserDetailsRepository userDetailsRepository;
}
