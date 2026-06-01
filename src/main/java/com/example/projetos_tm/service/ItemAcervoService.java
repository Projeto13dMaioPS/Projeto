// ItemAcervoService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.repository.ItemAcervoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemAcervoService {
    private final ItemAcervoRepository repository;

    public ItemAcervoService(ItemAcervoRepository repository) {
        this.repository = repository;
    }

    public List<ItemAcervo> listarTodos() { return repository.findAll(); }
    public ItemAcervo buscarPorNome(String nome) {return (ItemAcervo) repository.findByNome(nome); }
    public ItemAcervo buscarPorTipo(String tipo) { return (ItemAcervo) repository.findByTipo(tipo);}
    public ItemAcervo buscarPorDescricao(String descricao) { return (ItemAcervo) repository.findByDescricao(descricao);}


    public ItemAcervo salvar(ItemAcervo item) { return repository.save(item); }

    public void deletar(Long id) { repository.deleteById(id); }

}
