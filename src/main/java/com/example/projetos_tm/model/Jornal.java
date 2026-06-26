package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Jornal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String nome;

    @Column(nullable = false,length = 5000)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "itemAcervo")
    private ItemAcervo itemAcervo;

    public Jornal(UUID id, String nome, String descricao, ItemAcervo itemAcervo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.itemAcervo = itemAcervo;
    }

    public Jornal(String nome, String descricao, ItemAcervo itemAcervo) {
        this.nome = nome;
        this.descricao = descricao;
        this.itemAcervo = itemAcervo;
    }

    public Jornal() {}

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }
}
