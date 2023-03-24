package com.dfrb.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dfrb@ne
 */

@Controller
@RequestMapping("/secundario")
public class OtroControlador {
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		return "HolaAlumnosFormulario";
	}
	
	@RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		nombre += " es el mejor alumno";
		String mensajeFinal = "Quien es el mejor Alumno? "+ nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return "HolaAlumnosSpring";
	}
}
