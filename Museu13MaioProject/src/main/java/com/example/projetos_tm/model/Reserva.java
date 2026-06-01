package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "UsuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ExemplarId")
    private Exemplar exemplar;

    // Executa automaticamente antes de salvar o registro no banco
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now(); //pega o horario de agora
    }

    public Reserva(long id, LocalDateTime dataCriacao, Usuario usuario, Exemplar exemplar) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    public Reserva(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    public Reserva() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

}
