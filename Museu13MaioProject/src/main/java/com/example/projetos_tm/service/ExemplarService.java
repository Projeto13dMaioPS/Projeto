// ExemplarService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Exemplar;
import com.example.projetos_tm.repository.ExemplarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExemplarService {
    private final ExemplarRepository repository;

    public ExemplarService(ExemplarRepository repository) {
        this.repository = repository;
    }

    public List<Exemplar> listarTodos() { return repository.findAll(); }
    public List<Exemplar> listarDisponiveisDoItem(Long itemId) { return repository.findByItemAcervoIdAndEstadoTrue(itemId); }
    public Exemplar salvar(Exemplar exemplar) { return repository.save(exemplar); }
    public void deletar(Long id) { repository.deleteById(id); }
}
