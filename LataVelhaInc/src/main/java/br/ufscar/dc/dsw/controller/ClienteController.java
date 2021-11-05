package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;

import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cliente/*")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@Autowired 
	IPropostaService serviceProposta;
	

	@GetMapping("/listar")
	public String listarClientes(ModelMap model) {	
        model.addAttribute("listaClientes", service.buscarTodos());
		return "admin/listaClientes";
	}

	@GetMapping("/cadastrar")
	public String cadastroCliente(Cliente cliente) {
		return "admin/cadastroCliente";
	}

	@GetMapping("/editar{id}")
	public String preEdicaoCliente(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", service.buscarPorId(id));
		return "admin/cadastroCliente";
	}

	@PostMapping("/editar")
	public String EdicaoCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		service.salvar(cliente);
		attr.addFlashAttribute("success", "customer.edit.success");
		return "redirect:/cliente/listar";
	}

	@GetMapping("/remover{id}")
	public String remocaoCliente(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
        
		if (service.clienteTemPropostasAbertas(id)) {
			attr.addFlashAttribute("fail", "customer.delete.fail");
		}
		else {
			service.excluir(id);
	        attr.addFlashAttribute("success", "customer.delete.success");
		}
		
        return "redirect:/cliente/listar";
	}

	@PostMapping("/salvar")
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		service.salvar(cliente);
		attr.addFlashAttribute("success", "customer.create.success");
		return "redirect:/cliente/listar";
	}
}