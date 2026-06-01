// ReservaController.java
package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.*;
import com.example.projetos_tm.service.ReservaService;
import com.example.projetos_tm.service.ExemplarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final ExemplarService exemplarService;

    public ReservaController(ReservaService reservaService, ExemplarService exemplarService) {
        this.reservaService = reservaService;
        this.exemplarService = exemplarService;
    }

    @PostMapping("/solicitar/{itemId}")
    public String reservarItem(@PathVariable Long itemId, HttpSession session) {
        Usuario user = (Usuario) session.getAttribute("usuarioLogado");
        if (user == null) return "redirect:/login";

        List<Exemplar> disponiveis = exemplarService.listarDisponiveisDoItem(itemId);
        if (!disponiveis.isEmpty()) {
            Exemplar exemplar = disponiveis.get(0);
            exemplar.setEstado(false);
            exemplarService.salvar(exemplar);

            Reserva reserva = new Reserva(user, exemplar);
            reservaService.salvar(reserva);
            return "redirect:/operacoes/dashboard?success=reserva";
        }
        return "redirect:/operacoes/dashboard?error=indisponivel";
    }
}