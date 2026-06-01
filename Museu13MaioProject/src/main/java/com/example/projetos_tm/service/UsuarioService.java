package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // Regra de Autenticação para a sessão
    public Usuario realizarLogin(String email, String senha) {

        Optional<Usuario> opcional = repository.findByEmail(email);

        if (!opcional.isPresent()) {
            return null; //nao existe usuario com esse email
        }

        Usuario usuario = opcional.get();
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario; // Sucesso
        }
        return null; // Credenciais inválidas

    }
}
