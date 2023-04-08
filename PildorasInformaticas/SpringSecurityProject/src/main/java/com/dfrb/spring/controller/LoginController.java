package com.dfrb.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dfrb@ne
 */

@Controller
public class LoginController {
    @GetMapping("/formLogin")
    public String showFormLogin() {
        return "formLogin";
    }
}
