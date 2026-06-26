package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cidade;

    public Editora(UUID id, String idade, String nome) {
        this.id = id;
        this.cidade = cidade;
        this.nome = nome;
    }

    public Editora() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

