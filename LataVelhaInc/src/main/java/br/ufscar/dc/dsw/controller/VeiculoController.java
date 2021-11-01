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

import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;

@Controller
@RequestMapping("/veiculo/*")
public class VeiculoController {

    @Autowired
	private IVeiculoService service;
        
    @GetMapping("/adicionar")
	public String cadastroVeiculo(Veiculo Veiculo) {
		return "loja/cadastroVeiculo";
	}

	@GetMapping("/editar/{id}")
	public String preEdicaoVeiculo(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("veiculo", service.buscarPorId(id));
		return "loja/cadastroVeiculo";
	}

	@PostMapping("/editar")
	public String EdicaoVeiculo(@Valid Veiculo Veiculo, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "loja/cadastroVeiculo";
		}
		service.salvar(Veiculo);
		attr.addFlashAttribute("success", "vehicle.edit.success");
		return "redirect:/index";
	}

	@GetMapping("/remover")
	public String remocaoVeiculo(ModelMap model, @RequestParam Long id, RedirectAttributes attr) {
        service.excluir(id);
        attr.addFlashAttribute("success", "vehicle.delete.success");
        return "redirect:/index";
	}

	@PostMapping("/salvar")
	public String salvarVeiculo(@Valid Veiculo Veiculo, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "loja/cadastroVeiculo";
		}
		service.salvar(Veiculo);
		attr.addFlashAttribute("success", "vehicle.create.success");
		return "redirect:/index";
	}
}