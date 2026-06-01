package com.example.projetos_13maio.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "itemAcervoId")
    private ItemAcervo itemAcervo;

}
