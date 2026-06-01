
package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.MovimentacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping("/historico")
    public String verHistorico(HttpSession session, Model model) {
        Usuario user = (Usuario) session.getAttribute("usuarioLogado");
        if (user == null) return "redirect:/login";

        // Se for ADM vê tudo, senão vê só o seu próprio histórico
        if (user.getTipo().name().equals("ADMINISTRADOR")) {
            model.addAttribute("historico", movimentacaoService.listarHistorico());
        } else {
            model.addAttribute("historico", movimentacaoService.buscarPorUsuario(user.getId()));
        }
        return "historico"; // pode criar uma página historico.html em templates se quiser listar
    }
}
