package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.TipoItem;
import com.example.projetos_tm.service.ItemAcervoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ItemAcervoService itemAcervoService;

    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String termo,
            @RequestParam(required = false) TipoItem tipo,
            Model model) {
        
        model.addAttribute("itens", itemAcervoService.listarComFiltro(termo, tipo, true));

        model.addAttribute("termo", termo);
        model.addAttribute("tipo", tipo);

        return "index";
    }
}