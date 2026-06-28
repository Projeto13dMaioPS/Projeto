package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

    public void atualizarPerfil(UUID id, String nome, String email) {
        Usuario u = repository.findById(id).orElse(null);
        if (u != null) {
            u.setNome(nome);
            u.setEmail(email);
            repository.save(u);
        }
    }

    public boolean alterarSenha(UUID id, String senhaAtual, String novaSenha) {
        Usuario u = repository.findById(id).orElse(null);
        if (u != null && u.getSenha().equals(senhaAtual)) {
            u.setSenha(novaSenha);
            repository.save(u);
            return true;
        }
        return false;
    }

    public Usuario realizarLogin(String email, String senha) {
        Optional<Usuario> opcional = repository.findByEmail(email);
        if (!opcional.isPresent()) {
            return null;
        }
        Usuario usuario = opcional.get();
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
}