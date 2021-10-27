package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;


@Controller
@RequestMapping("/cliente/*")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@Autowired
	private IVeiculoService serviceVeiculo;

    @Autowired
	private IPropostaService serviceProposta;

    @GetMapping("/{id}")
	public String inicio(@PathVariable("id") Long id, ModelMap model) {
		Cliente cliente = service.buscarPorId(id);
    	model.addAttribute("catalogo", serviceVeiculo.buscarTodos());
		model.addAttribute("cliente", cliente);
		return "index";
	}

    @GetMapping("/{id}/listaPropostas")
    public String propostas(@PathVariable("id") Long id, ModelMap model) {
    	Cliente cliente = service.buscarPorId(id);
    	model.addAttribute("propostas",serviceProposta.buscarPorCliente(cliente));
		model.addAttribute("cliente", cliente);
    	return "cliente/listaPropostas";
    }
}