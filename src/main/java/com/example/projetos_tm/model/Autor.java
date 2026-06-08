package com.example.projetos_tm.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(updatable = false, nullable = false)
    private UUID nome;

    @Column(updatable = false, nullable = true)
    private UUID idade;

    public Autor(UUID id, UUID nome, UUID idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Autor() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getNome() {
        return nome;
    }

    public void setNome(UUID nome) {
        this.nome = nome;
    }

    public UUID getIdade() {
        return idade;
    }

    public void setIdade(UUID idade) {
        this.idade = idade;
    }
}

