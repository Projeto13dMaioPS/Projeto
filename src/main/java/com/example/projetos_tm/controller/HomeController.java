package com.example.projetos_tm.controller;

import com.example.projetos_tm.service.ItemAcervoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ItemAcervoService itemAcervoService;

    @GetMapping("/")
    public String index(Model model) {
        // Busca todos os itens do banco e envia para a view "index"
        model.addAttribute("itens", itemAcervoService.listarTodos());
        return "index";
    }
}