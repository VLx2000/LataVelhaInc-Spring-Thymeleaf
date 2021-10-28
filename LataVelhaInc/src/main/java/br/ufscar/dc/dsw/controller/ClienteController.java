package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;


@Controller
@RequestMapping("/cliente/*")
public class ClienteController {

	@Autowired
	private IClienteService service;

    @Autowired
	private IPropostaService serviceProposta;

    @Autowired
    private IVeiculoService serviceVeiculo;
 
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
    
    
    @GetMapping("/{id}/listaPropostas")
    public String propostas(@PathVariable("id") Long id, ModelMap model) {
    	Cliente cliente = service.buscarPorId(id);
    	model.addAttribute("propostas",serviceProposta.buscarPorCliente(cliente));
		model.addAttribute("cliente", cliente);
    	return "cliente/listaPropostas";
    }
    
	@GetMapping("/comprar/{id}")
    public String comprar(@PathVariable("id") Long id, ModelMap model) {
    	Veiculo veiculo = serviceVeiculo.buscarPorId(id);
    	Cliente cliente = service.buscarPorId(this.getUsuario().getId());
    	model.addAttribute("cliente",cliente);
    	model.addAttribute("propostas",serviceProposta.buscarPorCliente(cliente));
    	model.addAttribute("veiculo",veiculo);
    	return "cliente/comprar";
    }
}