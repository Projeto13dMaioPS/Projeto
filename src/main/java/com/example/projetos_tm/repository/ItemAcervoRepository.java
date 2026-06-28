package com.example.projetos_tm.repository;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemAcervoRepository extends JpaRepository<ItemAcervo, UUID> {

    @Query("SELECT i FROM ItemAcervo i WHERE " +
            "(:termo IS NULL OR :termo = '' OR LOWER(i.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR LOWER(i.autor) LIKE LOWER(CONCAT('%', :termo, '%'))) " +
            "AND (:tipo IS NULL OR i.tipo = :tipo)")
    List<ItemAcervo> filtrar(@Param("termo") String termo, @Param("tipo") TipoItem tipo);
}