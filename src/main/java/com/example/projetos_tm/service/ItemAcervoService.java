// ItemAcervoService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.repository.ItemAcervoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ItemAcervoService {

    @Autowired
    private ItemAcervoRepository repository;

    public List<ItemAcervo> listarTodos() { return repository.findAll(); }
    public ItemAcervo buscarPorNome(String nome) {return (ItemAcervo) repository.findByNome(nome); }
    public ItemAcervo buscarPorTipo(String tipo) { return (ItemAcervo) repository.findByTipo(tipo);}
    public ItemAcervo buscarPorDescricao(String descricao) { return (ItemAcervo) repository.findByDescricaoBreve(descricao);}
    public ItemAcervo buscarPorId(UUID id) { return (ItemAcervo) repository.findById(id).get();}



    public ItemAcervo salvar(ItemAcervo item) { return repository.save(item); }

    public void deletar(UUID id) { repository.deleteById(id); }

}

