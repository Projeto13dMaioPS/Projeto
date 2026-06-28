package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.repository.ObrasFavoritadasRepository;
import com.example.projetos_tm.service.JornalService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jornal")
public class JornalController {

    @Autowired // O Spring gerencia e injeta a instância correta aqui automaticamente
    private JornalService jornalService;

    @Autowired
    private ObrasFavoritadasRepository obrasFavoritadasRepository; // Adicionado

    @GetMapping("/acessarJornal/{item}")
    public String acessarJornal(@PathVariable ItemAcervo item, Model model, HttpSession session) {

        model.addAttribute("jornal", jornalService.buscarJornalPItem(item));
        model.addAttribute("imagem", item.getImagemEmBase64());

        // Lógica de Favorito
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        boolean jaFavoritou = false;

        if (usuarioLogado != null && item != null) {
            jaFavoritou = obrasFavoritadasRepository.findByUsuarioAndItemAcervo(usuarioLogado, item).isPresent();
        }

        model.addAttribute("jaFavoritou", jaFavoritou);

        return "detalhesItem";
    }
}