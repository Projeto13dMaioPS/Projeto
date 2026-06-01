// ReservaRepository.java
package com.example.projetos_tm.repository;
import com.example.projetos_tm.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {}