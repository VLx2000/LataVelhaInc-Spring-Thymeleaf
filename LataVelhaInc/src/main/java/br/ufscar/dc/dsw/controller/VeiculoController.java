package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Veiculo;

//import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ILojaService;
//import br.ufscar.dc.dsw.service.spec.IVeiculoService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;


@Controller
@RequestMapping("/veiculo/*")
public class VeiculoController {

    @Autowired
	private ILojaService service;
    
    @Autowired
    private IPropostaService serviceProposta;
    
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
    
    @GetMapping("/editar")
    public String editar(ModelMap model) {
    	Loja loja = service.buscarPorId(this.getUsuario().getId());
    	model.addAttribute("propostas",serviceProposta.buscarPorLoja(loja));
		model.addAttribute("loja", loja);
    	return "loja/listaPropostas";
    }

    @GetMapping("/adicionar")
    public String adicionar(ModelMap model) {
    	Loja loja = service.buscarPorId(this.getUsuario().getId());
    	model.addAttribute("propostas",serviceProposta.buscarPorLoja(loja));
		model.addAttribute("loja", loja);
    	return "loja/listaPropostas";
    }
}