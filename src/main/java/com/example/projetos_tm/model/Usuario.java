package com.example.projetos_tm.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    public Usuario(long id, String email, String senha, TipoUsuario tipo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String email, String senha, TipoUsuario tipo) {
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }


}
