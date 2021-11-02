package br.ufscar.dc.dsw.controller;
/*
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
*/
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
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ILojaService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;

//import javax.servlet.ServletContext;

@Controller
@RequestMapping("/veiculo/*")
public class VeiculoController {

	@Autowired
	private IVeiculoService service;

	@Autowired
	private ILojaService serviceLoja;
/*
	@Autowired
	ServletContext context;
*/
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
	public String preEdicaoVeiculo(@PathVariable("id") Long id, ModelMap model) /*throws IOException */{

		Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
		model.addAttribute("loja", loja);
		model.addAttribute("veiculo", service.buscarPorId(id));
/*
		List<String> fileList = new ArrayList<String>();

		String uploadPath = context.getRealPath("") + "images/" + id;
		File uploadDir = new File(uploadPath);

		File[] files = uploadDir.listFiles();

		if (files != null) {
			for (final File file : files) {
				fileList.add(file.getName());
			}
		}
		System.out.println(uploadPath);
		model.addAttribute("files", fileList);
*/
		return "loja/cadastroVeiculo";
	}

	@PostMapping("/editar")
	public String EdicaoVeiculo(@Valid Veiculo veiculo, ModelMap model, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
			model.addAttribute("loja", loja);
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
	public String salvarVeiculo(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attr, ModelMap model)/*,
		@RequestParam("file") MultipartFile file) throws IOException*/ {

		if (result.hasErrors()) {
			Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
			model.addAttribute("loja", loja);
			return "loja/cadastroVeiculo";
		}
/*
		String fileName = file.getOriginalFilename();

		String uploadPath = context.getRealPath("") + "images/" + veiculo.getId();
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		file.transferTo(new File(uploadDir, fileName));

		attr.addFlashAttribute("sucess", "File " + fileName + " has uploaded successfully!");
*/
		service.salvar(veiculo);
		attr.addFlashAttribute("success", "vehicle.create.success");
		return "redirect:/";
	}
}