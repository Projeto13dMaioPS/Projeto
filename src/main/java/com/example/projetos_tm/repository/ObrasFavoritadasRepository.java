package com.example.projetos_tm.repository;

import com.example.projetos_tm.model.ObrasFavoritadas;
import com.example.projetos_tm.model.Usuario;
import com.example.projetos_tm.model.ItemAcervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ObrasFavoritadasRepository extends JpaRepository<ObrasFavoritadas, UUID> {
    List<ObrasFavoritadas> findByUsuario(Usuario usuario);
    Optional<ObrasFavoritadas> findByUsuarioAndItemAcervo(Usuario usuario, ItemAcervo itemAcervo);
    boolean existsByUsuarioAndItemAcervo(Usuario usuario, ItemAcervo itemAcervo);
    void deleteByItemAcervo(ItemAcervo itemAcervo);
}