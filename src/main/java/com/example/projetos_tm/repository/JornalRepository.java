package com.example.projetos_tm.repository;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Jornal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JornalRepository extends JpaRepository<Jornal, UUID> {

    Optional<Jornal> findByItemAcervo(ItemAcervo itemAcervo);

}
