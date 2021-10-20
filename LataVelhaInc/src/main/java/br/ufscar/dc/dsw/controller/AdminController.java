package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;
//import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.ILojaService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @Autowired
	private ILojaService serviceLoja;
    @Autowired
	private IClienteService serviceCliente;
	
    @GetMapping("/")
	public String crud() {
		return "admin/crudLinks";
	}

	@GetMapping("/listarLojas")
	public String listarLojas(ModelMap model) {
		model.addAttribute("listaLojas", serviceLoja.buscarTodos());
		return "admin/listaLojas";
	}

    @GetMapping("/listarClientes")
	public String listarClientes(ModelMap model) {
        model.addAttribute("listaClientes", serviceCliente.buscarTodos());
		return "admin/listaClientes";
	}
}