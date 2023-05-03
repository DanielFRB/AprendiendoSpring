package com.dfrb.springjwt.payloads.response;

/**
 * @author dfrb@ne
 */

public class MessageResponse {
    public MessageResponse() {
    
    }
    
    public MessageResponse(String message) {
        this.message = message;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    // Campos de Clase
    private String message;
}
