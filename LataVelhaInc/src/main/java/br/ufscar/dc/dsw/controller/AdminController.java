package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.ILojaService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
	private ILojaService serviceLoja;
    @Autowired
	private IClienteService serviceCliente;
	
    @GetMapping("/")
	public String crud() {
		return "index";
	}

    @GetMapping("/listarClientes")
	public String listarClientes(ModelMap model) {
        model.addAttribute("listaClientes", serviceCliente.buscarTodos());
		return "admin/listaClientes";
	}

	@GetMapping("/cadastrarCliente")
	public String cadastroCliente(Cliente cliente) {
		return "admin/cadastroCliente";
	}

	@GetMapping("/editarCliente{id}")
	public String preEdicaoCliente(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", serviceCliente.buscarPorId(id));
		return "admin/cadastroCliente";
	}

	@PostMapping("/editarCliente")
	public String EdicaoCliente(@Valid Cliente cliente, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		serviceCliente.salvar(cliente);
		attr.addFlashAttribute("success", "customer.edit.success");
		return "redirect:/admin/listarClientes";
	}

	@GetMapping("/removerCliente")
	public String remocaoCliente(ModelMap model, @RequestParam Long id, RedirectAttributes attr) {
        serviceCliente.excluir(id);
        attr.addFlashAttribute("success", "customer.delete.success");
        return "redirect:/admin/listarClientes";
	}

	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/cadastroCliente";
		}
		serviceCliente.salvar(cliente);
		attr.addFlashAttribute("success", "customer.create.success");
		return "redirect:/admin/listarClientes";
	}

	@GetMapping("/listarLojas")
	public String listarLojas(ModelMap model) {
		model.addAttribute("listaLojas", serviceLoja.buscarTodos());
		return "admin/listaLojas";
	}

	@GetMapping("/cadastrarLoja")
	public String cadastroLoja(Loja loja) {
		return "admin/cadastroLoja";
	}

	@GetMapping("/editarLoja{id}")
	public String preEdicaoLoja(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("loja", serviceLoja.buscarPorId(id));
		return "admin/cadastroLoja";
	}

	@PostMapping("/editarLoja")
	public String EdicaoLoja(@Valid Loja loja, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/cadastroLoja";
		}
		serviceLoja.salvar(loja);
		attr.addFlashAttribute("success", "store.edit.success");
		return "redirect:/admin/listarLojas";
	}

	@GetMapping("/removerLoja")
	public String remocaoLoja(ModelMap model, @RequestParam Long id, RedirectAttributes attr) {
        serviceLoja.excluir(id);
        attr.addFlashAttribute("success", "store.delete.success");
		return "redirect:/admin/listarLojas";
	}

	@PostMapping("/salvarLoja")
	public String salvarLoja(@Valid Loja loja, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/cadastroLoja";
		}
		serviceLoja.salvar(loja);
		attr.addFlashAttribute("success", "store.create.success");
		return "redirect:/admin/listarLojas";
	}
}