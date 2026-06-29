package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.TipoItem;
import com.example.projetos_tm.repository.ItemAcervoRepository;
import com.example.projetos_tm.repository.ObrasFavoritadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemAcervoService {

    @Autowired
    private ItemAcervoRepository repository;

    @Autowired
    private ObrasFavoritadasRepository obrasFavoritadasRepository;

    public List<ItemAcervo> listarTodos() {
        return repository.findAll();
    }

    public ItemAcervo buscarPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public ItemAcervo salvar(ItemAcervo item) {
        return repository.save(item);
    }

    @Transactional
    public void desabilitar(UUID id) {
        ItemAcervo item = buscarPorId(id);
        if (item != null) {
            item.setAtivo(false);
            repository.save(item);
        }
    }

    public void reativar(UUID id) {
        ItemAcervo item = buscarPorId(id);
        if (item != null) {
            item.setAtivo(true);
            repository.save(item);
        }
    }

    @Transactional
    public void excluir(UUID id) {
        ItemAcervo item = buscarPorId(id);
        if (item != null) {
            obrasFavoritadasRepository.deleteByItemAcervo(item);
            repository.deleteById(id);
        }
    }

    public List<ItemAcervo> listarComFiltro(String termo, TipoItem tipo, Boolean ativo) {
        List<ItemAcervo> lista = repository.filtrar(termo, tipo);
        if (ativo != null) {
            return lista.stream()
                    .filter(i -> i.isAtivo() == ativo)
                    .collect(Collectors.toList());
        }
        return lista;
    }
}