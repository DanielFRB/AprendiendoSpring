package com.dfrb.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dfrb@ne
 */

@RestController
@RequestMapping("/")
public class AppController {
    @GetMapping
    public String testApp() {
        return "Hola Spring Security";
    }
}
