package com.dfrb.springjwt.payloads.response;

import java.util.List;

/**
 * @author dfrb@ne
 */

public class JwtResponse {
    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Getters y Setters
    public String getAccesToken() {
        return token;
    }

    public void setAccesToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getRoles() {
        return roles;
    }

    // Campos de Clase
    private String token;
    private String type = "Bearer ";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
