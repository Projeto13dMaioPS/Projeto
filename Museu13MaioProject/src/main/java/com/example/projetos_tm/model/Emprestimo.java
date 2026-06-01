package com.example.projetos_tm.model;

import jakarta.persistence.*;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int diasEmprestimo;

    @Column(nullable = false)
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "ExemplarId")
    private Exemplar exemplar;

    public Emprestimo(long id, int diasEmprestimo, boolean ativo, Exemplar exemplar) {
        this.id = id;
        this.diasEmprestimo = diasEmprestimo;
        this.ativo = ativo;
        this.exemplar = exemplar;
    }

    public Emprestimo(int diasEmprestimo, boolean ativo, Exemplar exemplar) {
        this.diasEmprestimo = diasEmprestimo;
        this.ativo = ativo;
        this.exemplar = exemplar;
    }

    public Emprestimo() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiasEmprestimo() {
        return diasEmprestimo;
    }

    public void setDiasEmprestimo(int diasEmprestimo) {
        this.diasEmprestimo = diasEmprestimo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

}
