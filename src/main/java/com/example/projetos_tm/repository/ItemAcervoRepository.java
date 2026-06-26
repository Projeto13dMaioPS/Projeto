// ItemAcervoRepository.java
package com.example.projetos_tm.repository;
import com.example.projetos_tm.model.ItemAcervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemAcervoRepository extends JpaRepository<ItemAcervo, UUID> {
    List<ItemAcervo> findByNome(String nome);
    List<ItemAcervo> findByTipo(String tipo);
    List<ItemAcervo> findByDescricao(String descricao);
    List<ItemAcervo> findById(int id);




}
