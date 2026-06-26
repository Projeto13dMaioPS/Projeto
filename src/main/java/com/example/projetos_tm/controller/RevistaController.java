package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/revista")
public class RevistaController {

    @Autowired
    private RevistaService revistaService;

    @GetMapping("/acessarRevista/{item}")
    public String acessarRevista(@PathVariable ItemAcervo item, Model model) {

        model.addAttribute("revista", revistaService.buscarRevistaPItem(item));
        model.addAttribute("imagem", item.getImagemEmBase64());

        return "detalhesItem";

    }
}
