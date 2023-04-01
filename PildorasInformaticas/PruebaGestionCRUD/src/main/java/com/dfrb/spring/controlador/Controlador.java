package com.dfrb.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfrb.spring.dao.ClienteDAO;
import com.dfrb.spring.entidad.Cliente;

/**
 * @author dfrb@ne
 */

@Controller
@RequestMapping("/cliente")
public class Controlador {
    @RequestMapping("/lista")
    public String listaClientes(Model modelo) {
	// Obtener Clientes del DAO
	List<Cliente> clientes = clienteDAO.getClientes();
		
	// Entregar los Clientes al Modelo
	modelo.addAttribute("clientes", clientes);
	return "lista_clientes";
    }
	
    @Autowired
    private ClienteDAO clienteDAO;
}
