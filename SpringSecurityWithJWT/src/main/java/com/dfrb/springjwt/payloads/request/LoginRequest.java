package com.dfrb.springjwt.payloads.request;

import javax.validation.constraints.NotBlank;

/**
 * @author dfrb@ne
 */

public class LoginRequest {
    public LoginRequest() {
    
    }

    // Setters y Getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // Campos de Clase
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
}
