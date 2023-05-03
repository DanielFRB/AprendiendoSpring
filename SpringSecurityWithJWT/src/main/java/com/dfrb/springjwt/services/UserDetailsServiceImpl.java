package com.dfrb.springjwt.services;

import com.dfrb.springjwt.domains.User;
import com.dfrb.springjwt.repositories.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dfrb@ne
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre de: " + username));
        return UserDetailsImpl.build(user);
    }
    
    @Autowired
    private UserRepository userRepository;
}
