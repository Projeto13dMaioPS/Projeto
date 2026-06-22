package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.service.JornalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jornal")
public class JornalController {

    @Autowired
    JornalService jornalService;

    @GetMapping("/acessarJornal/{item}")
    public String acessarJornal(@PathVariable ItemAcervo item, Model model) {

        model.addAttribute("jornal", jornalService.buscarJornalPItem(item));
        model.addAttribute("imagem", item.getImagem());

        return "detalhesItem";

    }

}
