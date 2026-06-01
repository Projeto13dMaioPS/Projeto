// MovimentacaoService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Movimentacao;
import com.example.projetos_tm.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimentacaoService {
    private final MovimentacaoRepository repository;

    public MovimentacaoService(MovimentacaoRepository repository) {
        this.repository = repository;
    }

    public List<Movimentacao> listarHistorico() { return repository.findAll(); }
    public List<Movimentacao> buscarPorUsuario(Long usuarioId) { return repository.findByUsuarioId(usuarioId); }
    public Movimentacao registrar(Movimentacao movimentacao) { return repository.save(movimentacao); }
}
