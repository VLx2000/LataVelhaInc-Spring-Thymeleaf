package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Veiculo;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.ILojaService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;


@Controller
@RequestMapping("/loja/*")
public class LojaController {

    @Autowired
	private ILojaService service;
    
    @Autowired
	private IVeiculoService serviceVeiculo;
	
    
    @GetMapping("/{id}")
	public String inicio(@PathVariable("id") Long id, ModelMap model) {
    	Loja loja = service.buscarPorId(id);
    	model.addAttribute("catalogo", serviceVeiculo.buscarTodosPorLoja(loja));
		return "loja/inicio";
	}
   

}