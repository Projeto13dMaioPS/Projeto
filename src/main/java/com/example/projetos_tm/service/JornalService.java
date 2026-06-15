package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Jornal;
import com.example.projetos_tm.repository.JornalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JornalService {

    @Autowired
    private JornalRepository jornalRepository;

    public Jornal buscarJornalPItem(ItemAcervo item){

        Optional<Jornal> jornal = jornalRepository.findByItemAcervo(item);

        if(jornal.isPresent()) return jornal.get();

        return null;

    }

}
