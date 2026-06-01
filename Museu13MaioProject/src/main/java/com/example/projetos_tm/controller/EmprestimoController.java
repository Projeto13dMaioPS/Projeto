// EmprestimoController.java
package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.*;
import com.example.projetos_tm.service.EmprestimoService;
import com.example.projetos_tm.service.ExemplarService;
import com.example.projetos_tm.service.MovimentacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;
    private final ExemplarService exemplarService;
    private final MovimentacaoService movimentacaoService;

    public EmprestimoController(EmprestimoService emprestimoService, ExemplarService exemplarService, MovimentacaoService movimentacaoService) {
        this.emprestimoService = emprestimoService;
        this.exemplarService = exemplarService;
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping("/solicitar/{itemId}")
    public String realizarEmprestimo(@PathVariable Long itemId, @RequestParam int dias, HttpSession session) {
        Usuario user = (Usuario) session.getAttribute("usuarioLogado");
        if (user == null) return "redirect:/login";
        if (user.getTipo().name().equals("USUARIO")) return "redirect:/operacoes/dashboard?error=negado";

        List<Exemplar> disponiveis = exemplarService.listarDisponiveisDoItem(itemId);
        if (!disponiveis.isEmpty()) {
            Exemplar exemplar = disponiveis.get(0);
            exemplar.setEstado(false);
            exemplarService.salvar(exemplar);

            Emprestimo emp = new Emprestimo(dias, true, exemplar);
            emprestimoService.salvar(emp);

            Movimentacao mov = new Movimentacao(user, emp, tipoMovimentacao.EMPRESTIMO);
            movimentacaoService.registrar(mov);

            return "redirect:/operacoes/dashboard?success=emprestimo";
        }
        return "redirect:/operacoes/dashboard?success=indisponivel";
    }
}
