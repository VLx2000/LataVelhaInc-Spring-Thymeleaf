package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.ILojaService;


@Controller
@RequestMapping("/loja/*")
public class LojaController {

    @Autowired
	private ILojaService service;

	@GetMapping("/listar")
	public String listarLojas(ModelMap model) {
		model.addAttribute("listaLojas", service.buscarTodos());
		return "admin/listaLojas";
	}

	@GetMapping("/cadastrar")
	public String cadastroLoja(Loja loja) {
		return "admin/cadastroLoja";
	}

	@GetMapping("/editar{id}")
	public String preEdicaoLoja(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("loja", service.buscarPorId(id));
		return "admin/cadastroLoja";
	}

	@PostMapping("/editar")
	public String EdicaoLoja(@Valid Loja loja, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/cadastroLoja";
		}
		service.salvar(loja);
		attr.addFlashAttribute("success", "store.edit.success");
		return "redirect:/loja/listar";
	}

	@GetMapping("/remover{id}")
	public String remocaoLoja(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		
		if (service.lojaTemPropostasAbertas(id)) {
			attr.addFlashAttribute("fail", "store.delete.fail");
		}
		else {
			service.excluir(id);
	        attr.addFlashAttribute("success", "store.delete.success");
		}
		return "redirect:/loja/listar";
	}

	@PostMapping("/salvar")
	public String salvarLoja(@Valid Loja loja, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "admin/cadastroLoja";
		}
		service.salvar(loja);
		attr.addFlashAttribute("success", "store.create.success");
		return "redirect:/loja/listar";
	}
}