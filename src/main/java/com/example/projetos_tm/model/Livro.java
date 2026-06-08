package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "editoraId")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "itemAcervoId")
    private ItemAcervo itemAcervo;

}