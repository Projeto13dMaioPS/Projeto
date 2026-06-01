// ExemplarController.java
package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.Exemplar;
import com.example.projetos_tm.service.ExemplarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exemplares")
public class ExemplarController {
    private final ExemplarService exemplarService;

    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @PostMapping("/novo")
    public String adicionarExemplar(@ModelAttribute Exemplar exemplar) {
        exemplarService.salvar(exemplar);
        return "redirect:/operacoes/dashboard";
    }
}
