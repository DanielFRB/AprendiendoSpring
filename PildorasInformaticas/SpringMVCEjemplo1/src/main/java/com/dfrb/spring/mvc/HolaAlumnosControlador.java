package com.dfrb.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dfrb@ne
 */

@Controller
public class HolaAlumnosControlador {
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		return "HolaAlumnosFormulario";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {
		return "HolaAlumnosSpring";
	}
	
	/* @RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {
		String nombre = request.getParameter("nombreAlumno");
		nombre += " es el mejor alumno";
		String mensajeFinal = "Quien es el mejor Alumno? "+ nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return "HolaAlumnosSpring";
	}*/
	
	// Uso de @RequestParam para sustituir HttpServletRequest
	@RequestMapping("/procesarFormulario2")
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		nombre += " es el mejor alumno";
		String mensajeFinal = "Quien es el mejor Alumno? "+ nombre;
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		return "HolaAlumnosSpring";
	}
}
