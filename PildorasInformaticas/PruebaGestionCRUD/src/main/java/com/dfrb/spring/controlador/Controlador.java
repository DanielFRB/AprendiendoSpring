package com.dfrb.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfrb.spring.dao.ClienteDAO;
import com.dfrb.spring.entidad.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/registroNuevoCliente")
    public String registroCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "nuevoCliente";
    }
    
    @PostMapping("/insertaCliente")
    public String insertaCliente(@ModelAttribute("cliente") Cliente cliente) {
        // Insertar Cliente en la BBDD
        clienteDAO.insertarCliente(cliente);
        return "redirect:/cliente/lista";
    }
    
    @GetMapping("modificaCliente")
    public String modificaCliente(@RequestParam("id") int id, Model model) {
        // Obtener el Cliente
        Cliente cliente = clienteDAO.getCliente(id);
        // Pasar el Objeto Cliente al Modelo
        model.addAttribute("cliente", cliente);
        // Enviar al Formulario
        return "nuevoCliente";
    }
    
    @GetMapping("eliminaCliente")
    public String eliminaCliente(@RequestParam("id") int id) {
        // Eliminar el Cliente
        clienteDAO.deleteCliente(id);
        return "redirect:/cliente/lista";
    }
	
    @Autowired
    private ClienteDAO clienteDAO;
}
