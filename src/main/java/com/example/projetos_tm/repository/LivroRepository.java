package com.example.projetos_tm.repository;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

    Optional<Livro> findByItemAcervo(ItemAcervo itemAcervo);

}
