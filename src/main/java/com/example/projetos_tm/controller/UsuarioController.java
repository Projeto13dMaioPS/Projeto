package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String telaLogin() {
        return "login"; // renderiza templates/login.html
    }

    @PostMapping("/login")
    public String logar(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        Usuario usuarioLogado = usuarioService.realizarLogin(email, senha);

        if (usuarioLogado != null) {
            session.setAttribute("usuarioLogado", usuarioLogado);
            return "redirect:/itemAcervo/dashboard"; // Vai para a listagem do acervo
        }

        return "redirect:/usuario/login?error=true";
    }

    @GetMapping("/logout")
    public String deslogar(HttpSession session) {
        session.invalidate(); // Destrói a sessão atual
        return "redirect:/"; // Volta para a página inicial pública
    }
}
