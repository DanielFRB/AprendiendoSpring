package com.dfrb.springjwt.controllers;

import com.dfrb.springjwt.domains.*;
import com.dfrb.springjwt.payloads.request.*;
import com.dfrb.springjwt.payloads.response.*;
import com.dfrb.springjwt.repositories.*;
import com.dfrb.springjwt.security.jwt.JwtUtils;
import com.dfrb.springjwt.services.UserDetailsImpl;
import java.util.*;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author dfrb@ne
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth);
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map((item) -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), 
                userDetails.getUsername(), userDetails.getEmail(), roles));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Nombre de Usuario ya existe!!!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email ya existe!!!"));
        }
        
        // Creacion de una nueva Cuenta de Usuario
        User user = new User(signUpRequest.getUsername(),  signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        
        if (strRoles == null) {
            Role userRoles = rolesRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
            roles.add(userRoles);
        } else {
            strRoles.forEach((role) -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = rolesRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: El Rol no se encuentra."));
                        roles.add(adminRole);
                    }
                    default -> {
                        Role userRole = rolesRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: El Rol no se encuentra."));
                        roles.add(userRole);
                    }
                }
            });
        }
        
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Registro de Usuario completado!!!"));
    }

    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RolesRepository rolesRepository;
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    JwtUtils jwtUtils;
}
