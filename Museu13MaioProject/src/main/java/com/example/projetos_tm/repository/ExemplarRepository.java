// ExemplarRepository.java (Apenas garantindo a assinatura)
package com.example.projetos_tm.repository;

import com.example.projetos_tm.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    List<Exemplar> findByItemAcervoIdAndEstadoTrue(Long itemAcervoId);
}
