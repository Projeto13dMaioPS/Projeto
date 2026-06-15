package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ItemAcervo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String nome;

    @Column(length = 5000,nullable = false)
    private String descricao;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItem tipo;


    public ItemAcervo(UUID id, String nome, String descricao, byte[] imagem, TipoItem tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public ItemAcervo(String nome, String descricao, byte[] imagem, TipoItem tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public ItemAcervo() {}

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}
