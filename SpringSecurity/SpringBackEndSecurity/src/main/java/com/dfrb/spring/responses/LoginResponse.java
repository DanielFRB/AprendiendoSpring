package com.dfrb.spring.responses;

/**
 * @author dfrb@ne
 */

public class LoginResponse {
    public LoginResponse() {
    
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    private String token;
}
