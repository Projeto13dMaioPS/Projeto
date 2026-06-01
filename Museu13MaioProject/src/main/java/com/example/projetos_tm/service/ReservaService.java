// ReservaService.java
package com.example.projetos_tm.service;

import com.example.projetos_tm.model.Reserva;
import com.example.projetos_tm.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listarTodas() { return repository.findAll(); }
    public Reserva salvar(Reserva reserva) { return repository.save(reserva); }
    public void deletar(Long id) { repository.deleteById(id); }
}
