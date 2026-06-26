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

    @Column(nullable = false,length = 5000)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "editora")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "itemAcervo")
    private ItemAcervo itemAcervo;

    public Livro(UUID id, ItemAcervo itemAcervo, Editora editora, String descricao, String titulo) {
        this.id = id;
        this.itemAcervo = itemAcervo;
        this.editora = editora;
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public Livro(String titulo, String descricao, Editora editora, ItemAcervo itemAcervo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.editora = editora;
        this.itemAcervo = itemAcervo;
    }

    public Livro() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }
}