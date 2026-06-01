// ItemAcervoRepository.java
package com.example.projetos_tm.repository;
import com.example.projetos_tm.model.ItemAcervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAcervoRepository extends JpaRepository<ItemAcervo, Long> {}
