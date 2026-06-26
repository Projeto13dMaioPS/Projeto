package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Livro;
import com.example.projetos_tm.model.Revista;
import com.example.projetos_tm.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RevistaService {

    @Autowired
    private RevistaRepository revistaRepository;

    public Revista buscarRevistaPItem(ItemAcervo item){

        Optional<Revista> revista = revistaRepository.findByItemAcervo(item);

        if (revista.isPresent()) return revista.get();

        return null;

    }

}
