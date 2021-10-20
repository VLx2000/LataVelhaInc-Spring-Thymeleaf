package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufscar.dc.dsw.service.spec.IVeiculoService;

@Controller
public class IndexController {

    @Autowired
	private IVeiculoService service;

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("catalogo", service.buscarTodos());
        return "index";
    }
}