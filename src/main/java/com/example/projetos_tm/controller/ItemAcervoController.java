package com.example.projetos_tm.controller;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.TipoItem;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.service.ItemAcervoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.UUID;

@Controller
@RequestMapping("/itemAcervo")
public class ItemAcervoController {

    @Autowired
    private ItemAcervoService itemAcervoService;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(required = false) String termo,
                            @RequestParam(required = false) TipoItem tipo,
                            @RequestParam(required = false) Boolean ativo,
                            HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/?error=negado";
        model.addAttribute("itens", itemAcervoService.listarComFiltro(termo, tipo, ativo));
        model.addAttribute("termo", termo);
        model.addAttribute("tipo", tipo);
        model.addAttribute("ativo", ativo);
        return "dashboard";
    }

    @GetMapping("/acessarItem/{id}")
    public String acessarItem(@PathVariable UUID id, Model model) {
        ItemAcervo item = itemAcervoService.buscarPorId(id);
        if (item == null) return "redirect:/";
        model.addAttribute("item", item);
        return "detalhesItem";
    }

    @GetMapping("/novo")
    public String formularioNovo(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        model.addAttribute("item", new ItemAcervo());
        return "novoitem";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ItemAcervo item, @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, RedirectAttributes ra) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        try {
            if (file != null && !file.isEmpty()) item.setImagem(file.getBytes());
            else if (item.getId() != null) {
                ItemAcervo itemExistente = itemAcervoService.buscarPorId(item.getId());
                if (itemExistente != null) item.setImagem(itemExistente.getImagem());
            }
            itemAcervoService.salvar(item);
            ra.addFlashAttribute("sucesso", "Item salvo com sucesso!");
        } catch (Exception e) {
            ra.addFlashAttribute("erro", "Erro ao salvar imagem: " + e.getMessage());
        }
        return "redirect:/itemAcervo/dashboard";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        ItemAcervo item = itemAcervoService.buscarPorId(id);
        model.addAttribute("item", item);
        return "novoitem";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable UUID id, HttpSession session, RedirectAttributes ra) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        itemAcervoService.excluir(id);
        ra.addFlashAttribute("sucesso", "Item excluído!");
        return "redirect:/itemAcervo/dashboard";
    }

    @PostMapping("/desabilitar/{id}")
    public String desabilitar(@PathVariable UUID id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        itemAcervoService.desabilitar(id);
        return "redirect:/itemAcervo/dashboard";
    }

    @PostMapping("/reativar/{id}")
    public String reativar(@PathVariable UUID id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null || !"ADMINISTRADOR".equals(usuario.getTipo().name())) return "redirect:/";
        itemAcervoService.reativar(id);
        return "redirect:/itemAcervo/dashboard";
    }
}