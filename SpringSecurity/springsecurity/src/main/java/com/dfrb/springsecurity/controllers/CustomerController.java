package com.dfrb.springsecurity.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dfrb@ne
 */

@RestController
@RequestMapping("v1")
public class CustomerController {
    @Autowired
    private SessionRegistry sessionRegistry;
    
    @GetMapping("/index")
    public String index() {
        return "Hola Mundo";
    }
    
    @GetMapping("/index2")
    public String index2() {
        return "Hola Mundo Not SECURED!!!";
    }
    
    @GetMapping("/session")
    public ResponseEntity<?> getDetailsSession() {
        String sessionId = "";
        User userObject = null;
        
        List<Object> listaSesiones = sessionRegistry.getAllPrincipals();
        for (Object session : listaSesiones) {
            if (session instanceof User) {
                userObject = (User) session;
            }
            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
            for (SessionInformation information : sessionInformations) {
                sessionId = information.getSessionId();
            }
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("response: ", "Hola Mundo");
        response.put("sessionId: ", sessionId);
        response.put("sessionUser: ", userObject);
        
        return ResponseEntity.ok(response);
    }
}
