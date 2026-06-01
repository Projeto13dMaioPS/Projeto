package com.example.projetos_tm.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private tipoMovimentacao tipoMovimentacao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "UsuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "EmprestimoId")
    private Emprestimo emprestimo;

    // Executa automaticamente antes de salvar o registro no banco
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now(); //pega o horario de agora
    }

    public Movimentacao(long id, tipoMovimentacao tipoMovimentacao, LocalDateTime dataCriacao, Usuario usuario, Emprestimo emprestimo) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        this.emprestimo = emprestimo;
    }

    public Movimentacao(Usuario usuario, Emprestimo emprestimo, tipoMovimentacao tipoMovimentacao) {
        this.usuario = usuario;
        this.emprestimo = emprestimo;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Movimentacao() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public tipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(tipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
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

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

}
