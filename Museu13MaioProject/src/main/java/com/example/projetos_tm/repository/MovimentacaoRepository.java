// MovimentacaoRepository.java
package com.example.projetos_tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    // Busca o histórico de movimentações de um usuário específico
    List<Movimentacao> findByUsuarioId(Long usuarioId);
}
