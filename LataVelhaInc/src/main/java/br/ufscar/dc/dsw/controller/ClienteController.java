package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Proposta;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;
import br.ufscar.dc.dsw.service.spec.ILojaService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.validation.Valid;

@Controller
@RequestMapping("/cliente/*")
public class ClienteController {

	@Autowired
	private IClienteService service;

    @Autowired
	private IPropostaService serviceProposta;

    @Autowired
    private IVeiculoService serviceVeiculo;
    
    @Autowired
    private ILojaService serviceLoja;
 
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
    public String comprar(@PathVariable("id") Long id, ModelMap model,Proposta proposta) {
    	Veiculo veiculo = serviceVeiculo.buscarPorId(id);
    	Loja loja = veiculo.getLoja();
    	Cliente cliente = service.buscarPorId(this.getUsuario().getId());
    	String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    	proposta.setCliente(cliente);
    	proposta.setLoja(loja);
    	proposta.setVeiculo(veiculo);
    	proposta.setData(data);
    	proposta.setEstado("ABERTO");
    	
    	
    	model.addAttribute("cliente",cliente);
    	model.addAttribute("propostas",serviceProposta.buscarPorCliente(cliente));
    	model.addAttribute("veiculo",veiculo);
    	
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			lista.add("/images/" + id + "/" + i + ".jpg");
		model.addAttribute("files", lista);
		if (lista != null)
			System.out.println(lista);
    	return "cliente/comprar";
    }
	
	@GetMapping("/comprar/salvarProposta")
    public String salvarProposta(@Valid Proposta proposta, BindingResult result, RedirectAttributes attr) {

    	
		if (result.hasErrors()) {
			return "cliente/comprar";
		}
    	
    	
		serviceProposta.salvar(proposta);
		attr.addFlashAttribute("sucess", "Proposta evniada com sucesso.");
		return "redirect:/cliente/listaPropostas";
    	
    }
}