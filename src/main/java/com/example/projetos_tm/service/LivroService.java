package com.example.projetos_tm.service;

import com.example.projetos_tm.model.ItemAcervo;
import com.example.projetos_tm.model.Livro;
import com.example.projetos_tm.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro buscarLivroPItem(ItemAcervo item){

        Optional<Livro> livro = livroRepository.findByItemAcervo(item);

        if (livro.isPresent()) return livro.get();

        return null;

    }

}
