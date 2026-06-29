package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.UUID;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String logar(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        Usuario usuarioLogado = usuarioService.realizarLogin(email, senha);
        if (usuarioLogado != null) {
            session.setAttribute("usuarioLogado", usuarioLogado);
            return "redirect:/itemAcervo/dashboard";
        }
        return "redirect:/usuario/login?error=true";
    }

    @GetMapping("/logout")
    public String deslogar(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/dashboard/usuarios")
    public String listar(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) {
            return "redirect:/";
        }
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "listausuarios";
    }

    @GetMapping("/dashboard/usuarios/novo")
    public String formularioNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
    }

    @PostMapping("/dashboard/usuarios/salvar")
    public String salvarNovo(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/usuario/dashboard/usuarios";
    }

    @GetMapping("/dashboard/usuarios/editar/{id}")
    public String editar(@PathVariable UUID id, Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null || !"ADMINISTRADOR".equals(usuarioLogado.getTipo().name())) {
            return "redirect:/";
        }
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "editarUsuario";
    }

    @PostMapping("/dashboard/usuarios/editar")
    public String salvarEdicao(@ModelAttribute Usuario usuario) {
        Usuario existente = usuarioService.buscarPorId(usuario.getId());
        if (existente != null) {
            existente.setNome(usuario.getNome());
            existente.setEmail(usuario.getEmail());
            existente.setTipo(usuario.getTipo());
            usuarioService.salvar(existente);
        }
        return "redirect:/usuario/dashboard/usuarios";
    }

    @PostMapping("/dashboard/usuarios/deletar/{id}")
    public String deletarUsuario(@PathVariable UUID id, HttpSession session, RedirectAttributes ra) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) {
            return "redirect:/";
        }
        usuarioService.deletar(id);
        ra.addFlashAttribute("sucesso", "Usuário removido com sucesso!");
        return "redirect:/usuario/dashboard/usuarios";
    }

    @GetMapping("/meu-perfil")
    public String meuPerfil(HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogado");
        if (u == null) return "redirect:/usuario/login";
        model.addAttribute("usuario", usuarioService.buscarPorId(u.getId()));
        return "meuPerfil";
    }

    @PostMapping("/meu-perfil/atualizar")
    public String atualizarPerfil(@ModelAttribute Usuario usuario, HttpSession session, RedirectAttributes ra) {
        Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
        if (logado == null) return "redirect:/usuario/login";

        usuarioService.atualizarPerfil(logado.getId(), usuario.getNome(), usuario.getEmail());
        logado.setNome(usuario.getNome());
        logado.setEmail(usuario.getEmail());

        ra.addFlashAttribute("sucesso", "Perfil atualizado!");
        return "redirect:/usuario/meu-perfil";
    }

    @PostMapping("/meu-perfil/senha")
    public String alterarSenha(@RequestParam String senhaAtual, @RequestParam String novaSenha, HttpSession session, RedirectAttributes ra) {
        Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
        if (logado == null) return "redirect:/usuario/login";

        if (usuarioService.alterarSenha(logado.getId(), senhaAtual, novaSenha)) {
            ra.addFlashAttribute("sucesso", "Senha alterada com sucesso!");
        } else {
            ra.addFlashAttribute("erro", "Senha atual incorreta!");
        }
        return "redirect:/usuario/meu-perfil";
    }
}