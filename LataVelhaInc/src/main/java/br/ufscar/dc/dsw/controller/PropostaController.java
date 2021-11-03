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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Proposta;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.impl.EmailService;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.ILojaService;
import br.ufscar.dc.dsw.service.spec.IVeiculoService;
import br.ufscar.dc.dsw.service.spec.IPropostaService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.validation.Valid;

@Controller
@RequestMapping("/proposta/*")
public class PropostaController {

	@Autowired
	private ILojaService serviceLoja;

	@Autowired
	private IClienteService serviceCliente;

	@Autowired
	private IPropostaService serviceProposta;

	@Autowired
	private IVeiculoService serviceVeiculo;

	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return usuarioDetails.getUsuario();
	}

	@GetMapping("/listarPropostasLoja")
	public String propostasLoja(ModelMap model) {
		Loja loja = serviceLoja.buscarPorId(this.getUsuario().getId());
		model.addAttribute("propostas", serviceProposta.buscarPorLoja(loja));
		model.addAttribute("loja", loja);
		return "listaPropostas";
	}

	@GetMapping("/listarPropostasCliente")
	public String propostasCliente(ModelMap model) {
		Cliente cliente = serviceCliente.buscarPorId(this.getUsuario().getId());
		
		model.addAttribute("propostas", serviceProposta.buscarPorCliente(cliente));
		model.addAttribute("cliente", cliente);
		return "listaPropostas";
	}

	@GetMapping("/comprar/{id}")
	public String comprar(@PathVariable("id") Long id, ModelMap model, Proposta proposta) {
		Veiculo veiculo = serviceVeiculo.buscarPorId(id);
		Loja loja = veiculo.getLoja();
		Cliente cliente = serviceCliente.buscarPorId(this.getUsuario().getId());
		String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

		proposta.setCliente(cliente);
		proposta.setLoja(loja);
		proposta.setVeiculo(veiculo);
		proposta.setData(data);
		proposta.setEstado("ABERTO");

		List<Proposta> lista_propostas = serviceProposta.buscarPorCliente(cliente);
		for (int i = 0; i < lista_propostas.size(); i++) {
			if (lista_propostas.get(i).getVeiculo().getId() == id
					&& lista_propostas.get(i).getEstado().equals("ABERTO")) {
				model.addAttribute("proposta_aberta", lista_propostas.get(i));
			}
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("veiculo", veiculo);

		ArrayList<String> lista = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			lista.add("/images/" + id + "/" + i + ".jpg");
		model.addAttribute("files", lista);
		model.addAttribute("n_fotos", veiculo.getN_fotos());
		return "cliente/comprar";
	}

	@PostMapping("/salvar")
	public String salvarProposta(@Valid Proposta proposta, BindingResult result, RedirectAttributes attr,
			ModelMap model) {
		if (result.hasErrors()) {
			Cliente cliente = serviceCliente.buscarPorId(this.getUsuario().getId());
			model.addAttribute("cliente", cliente);

			return "cliente/comprar";
		}

		serviceProposta.salvar(proposta);
		attr.addFlashAttribute("sucess", "Proposta enviada com sucesso.");
		return "redirect:/proposta/listarPropostasCliente";

	}

	@GetMapping("/cancelar/{id}")
	public String cancelarProposta(@PathVariable("id") Long id, RedirectAttributes attr, ModelMap model) {
		Proposta proposta = serviceProposta.buscarPorId(id);
		if (proposta.getCliente().equals(this.getUsuario()) && proposta.getEstado().equals("ABERTO")) {
			serviceProposta.excluir(id);
			attr.addFlashAttribute("sucess", "proposta.delete.sucess");
			return "redirect:/proposta/listarPropostasCliente";
		}

		Cliente cliente = serviceCliente.buscarPorId(this.getUsuario().getId());
		model.addAttribute("cliente", cliente);
		return "cliente/comprar";
	}

	@GetMapping("/aceitar/{id_proposta}")
	public String aceitarProposta(@PathVariable("id_proposta") Long id_proposta, /* String mensagem, */ RedirectAttributes attr,
			ModelMap model, EmailService service) throws UnsupportedEncodingException {
		Proposta proposta = serviceProposta.buscarPorId(id_proposta);
		if (proposta.getLoja().equals(this.getUsuario()) && proposta.getEstado().equals("ABERTO")) {
/*
			InternetAddress from, to;
			try {
				from = new InternetAddress(proposta.getLoja().getNome(), proposta.getLoja().getUsername());
				to = new InternetAddress(proposta.getCliente().getNome(), proposta.getCliente().getUsername());

				String subject = "Sua proposta para compra de " + proposta.getVeiculo().getModelo() + " foi ACEITA!";
				String body = "mensagem" + " Link para a videochamada: https://meet.google.com/ooe-xsvv-orm";
				System.out.println(from);
				System.out.println(to);
				System.out.println(subject);
				System.out.println(body);

				service.send(from, to, subject, body);

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
*/
			proposta.setEstado("ACEITO");
			attr.addFlashAttribute("success", "proposta.acceptance.success");
			serviceProposta.salvar(proposta);
		}
		return "redirect:/proposta/listarPropostasLoja";
	}

	@GetMapping("/negar/{id_proposta}")
	public String negarProposta(@PathVariable("id_proposta") Long id_proposta,/*  String mensagem, */ RedirectAttributes attr, ModelMap model,
			EmailService service) {
		Proposta proposta = serviceProposta.buscarPorId(id_proposta);
		if (proposta.getLoja().getId().equals(this.getUsuario().getId())) {
/*
			InternetAddress from, to;
			try {
				from = new InternetAddress(proposta.getLoja().getNome(), proposta.getLoja().getUsername());
				to = new InternetAddress(proposta.getCliente().getNome(), proposta.getCliente().getUsername());

				String subject = "Sua proposta para compra de " + proposta.getVeiculo().getModelo() + " foi NEGADA!";
				String body = "mensagem";

				service.send(from, to, subject, body);

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
*/
			proposta.setEstado("RECUSADO");
			attr.addFlashAttribute("success", "proposta.acceptance.success");
			serviceProposta.salvar(proposta);
		}
		return "redirect:/proposta/listarPropostasLoja";
	}
}
