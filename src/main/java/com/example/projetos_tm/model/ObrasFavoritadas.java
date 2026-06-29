package com.example.projetos_tm.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class ObrasFavoritadas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false, name = "item_acervo_id")
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
