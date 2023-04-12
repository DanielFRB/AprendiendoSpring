package com.dfrb.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dfrb@ne
 */

@RestController
@RequestMapping("/prueba")
public class WebAppController {
    @GetMapping("/saludo")
    public String saludoPrueba() {
        return "Saludos";
    }
}
