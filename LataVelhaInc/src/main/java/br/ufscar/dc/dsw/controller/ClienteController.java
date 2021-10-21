package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;


@Controller
@RequestMapping("/cliente/*")
public class ClienteController {

    @Autowired
	private IClienteService service;
    
    @Autowired
	private IVeiculoService serviceVeiculo;
	
    @GetMapping("/")
	public String inicio(ModelMap model) {
    	model.addAttribute("catalogo", serviceVeiculo.buscarTodos());
		return "cliente/inicio";
	}
   

}