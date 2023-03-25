package com.dfrb.spring.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author dfrb@ne
 */

@Controller
@RequestMapping("/alumno")
public class AlumnosControlador {
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model modelo) {
		Alumno miAlumno = new Alumno();
		modelo.addAttribute("miAlumno", miAlumno);
		return "registroAlumnoFormulario";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@Valid @ModelAttribute("miAlumno") Alumno miAlumno, BindingResult resultadoValidacion) {
		if (resultadoValidacion.hasErrors()) {
			System.out.println(resultadoValidacion.toString());
			return "registroAlumnoFormulario";
		} else {
			return "confirmacionRegistroAlumno";
		}
	}
}
