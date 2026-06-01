package com.example.projetos_tm.model;

import jakarta.persistence.*;

@Entity
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codigoBarras;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "ItemAcervoId")
    private ItemAcervo itemAcervo;

    public Exemplar(long id, String codigoBarras, String localizacao, boolean estado, ItemAcervo itemAcervo) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.localizacao = localizacao;
        this.estado = estado;
        this.itemAcervo = itemAcervo;
    }

    public Exemplar(String codigoBarras, String localizacao, boolean estado, ItemAcervo itemAcervo) {
        this.codigoBarras = codigoBarras;
        this.localizacao = localizacao;
        this.estado = estado;
        this.itemAcervo = itemAcervo;
    }

    public Exemplar(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }
}
