// EmprestimoService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Emprestimo;
import com.example.projetos_tm.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public List<Emprestimo> listarTodos() { return repository.findAll(); }
    public Emprestimo buscarPorId(Long id) { return repository.findById(id).orElse(null); }
    public Emprestimo salvar(Emprestimo emprestimo) { return repository.save(emprestimo); }
}
