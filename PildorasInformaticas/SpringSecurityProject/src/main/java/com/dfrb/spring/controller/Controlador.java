package com.dfrb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dfrb@ne
 */

@Controller
public class Controlador {
    @GetMapping("/")
    public String showInicio() {
        return "index";
    }
    
    @GetMapping("/admin")
    public String showAdminZone() {
        return "adminZone";
    }
    
    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "accessDenied";
    }
}
