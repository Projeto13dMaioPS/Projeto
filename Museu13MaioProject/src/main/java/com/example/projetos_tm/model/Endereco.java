package com.example.projetos_tm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column(nullable = false,length = 9)
    private String cep;
    @Column(nullable = false,length = 20)
    private String tipoMoradia;
    @Column(nullable = false)
    private int numero;

}
