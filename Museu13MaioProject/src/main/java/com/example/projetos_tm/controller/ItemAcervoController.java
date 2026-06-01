package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.ItemAcervoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itens")
public class ItemAcervoController {

    private final ItemAcervoService itemAcervoService;

    public ItemAcervoController(ItemAcervoService itemAcervoService) {
        this.itemAcervoService = itemAcervoService;
    }

    @GetMapping
    public String exibirDashboard(HttpSession session, Model model) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        // Proteção de rota: se tentar acessar sem logar, barra
        if (usuarioLogado == null) {
            return "redirect:/usuario/login";
        }

        model.addAttribute("itens", itemAcervoService.listarTodos());
        return "dashboard"; // renderiza templates/dashboard.html
    }

    @PostMapping("/novo")
    public String cadastrar(@ModelAttribute ItemAcervo item, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null || usuarioLogado.getTipo().name().equals("USUARIO")) {
            return "redirect:/itens?error=negado";
        }
        itemAcervoService.salvar(item);
        return "redirect:/itens";
    }
}
