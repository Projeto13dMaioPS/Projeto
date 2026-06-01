package com.example.projetos_13maio.model;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.UUID;

@Entity
public class ObrasFavoritadas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "usuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false, name = "itemAcervoId")
    private ItemAcervo itemAcervo;

    public ObrasFavoritadas(UUID id, Usuario usuario, ItemAcervo itemAcervo) {
        this.id = id;
        this.usuario = usuario;
        this.itemAcervo = itemAcervo;
    }

    public ObrasFavoritadas(Usuario usuario, ItemAcervo itemAcervo) {
        this.usuario = usuario;
        this.itemAcervo = itemAcervo;
    }

    public ObrasFavoritadas() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }

}
