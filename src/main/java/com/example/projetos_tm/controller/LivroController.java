package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/acessarLivro/{item}")
    public String acessarLivro(@PathVariable ItemAcervo item, Model model) {

        model.addAttribute("livro", livroService.buscarLivroPItem(item));

        return "detalhesItem";

    }

}
