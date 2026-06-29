package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ObrasFavoritadas;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.repository.ObrasFavoritadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ObrasFavoritadasService {

    @Autowired
    private ObrasFavoritadasRepository repository;

    public List<ObrasFavoritadas> listarFavoritosPorUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    public void favoritarItem(Usuario usuario, com.example.projetos_tm.model.ItemAcervo item) {
        if (!repository.existsByUsuarioAndItemAcervo(usuario, item)) {
            ObrasFavoritadas fav = new ObrasFavoritadas();
            fav.setUsuario(usuario);
            fav.setItemAcervo(item);
            repository.save(fav);
        }
    }

    public void desfavoritarItem(Usuario usuario, com.example.projetos_tm.model.ItemAcervo item) {
        repository.findByUsuarioAndItemAcervo(usuario, item)
                .ifPresent(repository::delete);
    }

    public void excluirFavorito(UUID id) {
        repository.deleteById(id);
    }
}