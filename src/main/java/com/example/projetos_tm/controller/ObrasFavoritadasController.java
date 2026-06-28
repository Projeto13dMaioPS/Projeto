package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ObrasFavoritadas;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.ItemAcervoService;
import com.example.projetos_tm.service.ObrasFavoritadasService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/favoritos")
public class ObrasFavoritadasController {

    @Autowired
    private ObrasFavoritadasService favoritosService;

    @Autowired
    private ItemAcervoService itemAcervoService;

    @GetMapping
    public String listarFavoritos(HttpSession session, Model model) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) return "redirect:/usuario/login";

        List<ObrasFavoritadas> todosFavoritos = favoritosService.listarFavoritosPorUsuario(usuarioLogado);

        List<ObrasFavoritadas> ativos = todosFavoritos.stream()
                .filter(f -> f.getItemAcervo() != null && f.getItemAcervo().isAtivo())
                .collect(Collectors.toList());

        boolean temInativo = todosFavoritos.size() > ativos.size();

        if (temInativo) {
            Boolean avisoJaExibido = (Boolean) session.getAttribute("avisoExibido");
            if (avisoJaExibido == null || !avisoJaExibido) {
                model.addAttribute("aviso", "Alguns itens da sua lista foram desativados do catálogo.");
                session.setAttribute("avisoExibido", true);
            }
        } else {
            session.setAttribute("avisoExibido", false);
        }

        model.addAttribute("favoritos", ativos);
        return "meusFavoritos";
    }

    @PostMapping("/adicionar/{id}")
    public String adicionar(@PathVariable("id") UUID id, HttpServletRequest request, HttpSession session, RedirectAttributes ra) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) return "redirect:/usuario/login";

        var item = itemAcervoService.buscarPorId(id);
        if (item != null) {
            favoritosService.favoritarItem(usuario, item);
            ra.addFlashAttribute("sucesso", "Obra favoritada com sucesso!");
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/");
    }

    @PostMapping("/remover/{id}")
    public String remover(@PathVariable("id") UUID id, HttpSession session, RedirectAttributes ra) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) return "redirect:/usuario/login";

        session.setAttribute("avisoExibido", false);

        var item = itemAcervoService.buscarPorId(id);
        if (item != null) {
            favoritosService.desfavoritarItem(usuario, item);
            ra.addFlashAttribute("sucesso", "Removido dos favoritos!");
        }
        return "redirect:/favoritos";
    }
}