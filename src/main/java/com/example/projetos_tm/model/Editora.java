package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

}

