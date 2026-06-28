package com.example.projetos_tm.repository;
import com.example.projetos_tm.model.ItemAcervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemAcervoRepository extends JpaRepository<ItemAcervo, UUID> {
    List<ItemAcervo> findByNome(String nome);
    List<ItemAcervo> findByTipo(String tipo);
    List<ItemAcervo> findByDescricaoBreve(String descricao);
    Optional<ItemAcervo> findById(UUID id);




}
