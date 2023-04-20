package com.dfrb.spring.request;

/**
 * @author dfrb@ne
 */

public class AuthenticationRequest {
    public AuthenticationRequest() {
    
    }
    
    public String getUserName() {
	return userName;
    }
	
    public String getPassword() {
	return password;
    }
    
    private String userName;
    private String password;
}
