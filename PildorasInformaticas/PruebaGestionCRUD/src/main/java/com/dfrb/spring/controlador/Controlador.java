package com.dfrb.spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dfrb@ne
 */

@Controller
@RequestMapping("/cliente")
public class Controlador {
	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		return "lista_clientes";
	}
}
