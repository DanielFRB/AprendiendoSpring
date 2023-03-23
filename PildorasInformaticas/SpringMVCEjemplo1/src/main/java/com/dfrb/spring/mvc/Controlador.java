package com.dfrb.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dfrb@ne
 */

@Controller
public class Controlador {
	@RequestMapping
	public String showPagina() {
		return "paginaEjemplo";
	}
}
