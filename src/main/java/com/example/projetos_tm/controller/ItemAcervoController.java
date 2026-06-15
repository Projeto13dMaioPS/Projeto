package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.ItemAcervoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itemAcervo")
public class ItemAcervoController {


    private final ItemAcervoService itemAcervoService;

    public ItemAcervoController(ItemAcervoService itemAcervoService) {
        this.itemAcervoService = itemAcervoService;
    }

    @GetMapping("/dashboard")
    public String exibirDashboard(HttpSession session, Model model) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        // Proteção de rota: se tentar acessar sem logar, barra
        if (usuarioLogado == null) {
            return "redirect:/usuario/login";
        }

        model.addAttribute("itens", itemAcervoService.listarTodos());
        return "dashboard"; // renderiza templates/dashboard.html
    }

    @PostMapping("/novoItem")
    public String cadastrar(@ModelAttribute ItemAcervo item, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null || usuarioLogado.getTipo().name().equals("USUARIO")) {
            return "redirect:/itens?error=negado";
        }
        itemAcervoService.salvar(item);
        return "redirect:/itemAcervo/dashboard";
    }

    @GetMapping("/acessarItem")
    public String acessarItem(Model model,@RequestParam ItemAcervo item) {

        if (item.getTipo().name().equals("LIVRO")) return "redirect:/livro/acessarLivro/{item}";
        if (item.getTipo().name().equals("JORNAL")) return "redirect:/jornal/acessarJornal/{item}";
        if (item.getTipo().name().equals("REVISTA")) return "redirect:/revista/acessarRevista/{item}";
        return "redirect:/outro/acessarOutro/{item}";

    }

}
