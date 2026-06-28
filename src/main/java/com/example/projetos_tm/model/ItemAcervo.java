package com.example.projetos_tm.model;

import jakarta.persistence.*;
import java.util.Base64;
import java.util.UUID;

@Entity
public class ItemAcervo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricaoBreve;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItem tipo;

    @Column(nullable = false)
    private boolean ativo = true;

    private String autor;

    private String isbn;

    private String edicao;

    public ItemAcervo() {
    }

    public ItemAcervo(UUID id, String nome, String descricaoBreve, byte[] imagem, TipoItem tipo, boolean ativo, String autor, String isbn, String edicao) {
        this.id = id;
        this.nome = nome;
        this.descricaoBreve = descricaoBreve;
        this.imagem = imagem;
        this.tipo = tipo;
        this.ativo = ativo;
        this.autor = autor;
        this.isbn = isbn;
        this.edicao = edicao;
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

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getImagemEmBase64() {
        if (imagem == null) return null;
        return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imagem);
    }
}