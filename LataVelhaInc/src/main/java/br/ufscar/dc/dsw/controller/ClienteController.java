package br.ufscar.dc.dsw.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    
 
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}

	@GetMapping("/listarClientes")
	public String listarClientes(ModelMap model) {
        model.addAttribute("listaClientes", service.buscarTodos());
		return "admin/listaClientes";
	}

	@GetMapping("/cadastrarCliente")
	public String cadastroCliente(Cliente cliente) {
		return "admin/cadastroCliente";
	}

	@GetMapping("/editarCliente{id}")
	public String preEdicaoCliente(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", service.buscarPorId(id));
		return "admin/cadastroCliente";
	}

	@PostMapping("/editarCliente")
	public String EdicaoCliente(@Valid Cliente cliente, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		service.salvar(cliente);
		attr.addFlashAttribute("success", "customer.edit.success");
		return "redirect:/cliente/listarClientes";
	}

	@GetMapping("/removerCliente")
	public String remocaoCliente(ModelMap model, @RequestParam Long id, RedirectAttributes attr) {
        service.excluir(id);
        attr.addFlashAttribute("success", "customer.delete.success");
        return "redirect:/cliente/listarClientes";
	}

	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		service.salvar(cliente);
		attr.addFlashAttribute("success", "customer.create.success");
		return "redirect:/cliente/listarClientes";
	}
}