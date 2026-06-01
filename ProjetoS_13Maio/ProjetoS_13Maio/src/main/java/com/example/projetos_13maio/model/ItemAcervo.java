package com.example.projetos_13maio.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ItemAcervo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItem tipo;

    public ItemAcervo(UUID id, String nome, byte[] imagem, TipoItem tipo) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public ItemAcervo(String nome, byte[] imagem, TipoItem tipo) {
        this.nome = nome;
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
