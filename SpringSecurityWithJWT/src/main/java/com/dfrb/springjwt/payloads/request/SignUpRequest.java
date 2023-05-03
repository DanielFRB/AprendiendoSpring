package com.dfrb.springjwt.payloads.request;

import java.util.Set;
import javax.validation.constraints.*;

/**
 * @author dfrb@ne
 */

public class SignUpRequest {
    public SignUpRequest() {
    
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    // Campos de Clase
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;
    
    @NotBlank
    @Size(max = 60)
    private String email;
    
    @NotBlank
    @Size(min = 8, max = 60)
    private String password;
    
    private Set<String> roles;
}
