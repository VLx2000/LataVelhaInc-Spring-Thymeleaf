package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ILojaService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;

@Controller
@RequestMapping("/veiculo/*")
public class VeiculoController {

    @Autowired
	private IVeiculoService service;

	@Autowired
	private ILojaService serviceLoja;

	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
        
    @GetMapping("/adicionar")
	public String cadastroVeiculo(Veiculo veiculo, ModelMap model) {
		Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
		model.addAttribute("loja", loja);
		veiculo.setLoja(loja);
		return "loja/cadastroVeiculo";
	}

	@GetMapping("/editar/{id}")
	public String preEdicaoVeiculo(@PathVariable("id") Long id, ModelMap model) {
		Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
		model.addAttribute("loja", loja);
        model.addAttribute("veiculo", service.buscarPorId(id));
		return "loja/cadastroVeiculo";
	}

	@PostMapping("/editar")
	public String EdicaoVeiculo(@Valid Veiculo veiculo, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "loja/cadastroVeiculo";
		}
		service.salvar(veiculo);
		attr.addFlashAttribute("success", "vehicle.edit.success");
		return "redirect:/";
	}

	@GetMapping("/remover/{id}")
	public String remocaoVeiculo(ModelMap model, @PathVariable("id") Long id, RedirectAttributes attr) {
        service.excluir(id);
        attr.addFlashAttribute("success", "vehicle.delete.success");
        return "redirect:/";
	}

	@PostMapping("/salvar")
	public String salvarVeiculo(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attr, ModelMap model) {

		if (result.hasErrors()) {
			return "loja/cadastroVeiculo";
		}
		service.salvar(veiculo);
		attr.addFlashAttribute("success", "vehicle.create.success");
		return "redirect:/";
	}
}