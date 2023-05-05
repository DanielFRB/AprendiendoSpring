package com.dfrb.spring.controller;

import com.dfrb.spring.entities.Empleado;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dfrb@ne
 */

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Daniel", "Rondón"));
        listaEmpleados.add(new Empleado("Yaneth", "Machado"));
        listaEmpleados.add(new Empleado("Oswaldo", "López"));
        listaEmpleados.add(new Empleado("Barack", "Obama"));
        return listaEmpleados;
    }
}
