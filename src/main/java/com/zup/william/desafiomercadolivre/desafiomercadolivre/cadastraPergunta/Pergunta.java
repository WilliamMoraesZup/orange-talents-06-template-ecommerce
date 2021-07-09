package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Pergunta implements Comparable<Pergunta> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private Instant momentoDeCriacao = Instant.now();

    @NotNull
    @ManyToOne
    private Usuario perguntador;

    @NotNull
    @ManyToOne
    private Produto produto;

    public String getTitulo() {
        return titulo;
    }

    public Pergunta() {
    }

    public Pergunta(String titulo, Usuario perguntador, Produto produto) {
        this.titulo = titulo;
        this.perguntador = perguntador;
        this.produto = produto;
    }

    public Instant getMomentoDeCriacao() {
        return momentoDeCriacao;
    }

    public void setMomentoDeCriacao(Instant momentoDeCriacao) {
        this.momentoDeCriacao = momentoDeCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pergunta pergunta = (Pergunta) o;
        return titulo.equals(pergunta.titulo) && momentoDeCriacao.equals(pergunta.momentoDeCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, momentoDeCriacao);
    }

    @Override
    public int compareTo(Pergunta o) {
        return this
                .titulo.compareTo(o.titulo);
    }

    public Usuario getPerguntador() {
        return perguntador;
    }

    public String getDonoProduto() {
        return produto.getUsuarioVendedor().getLogin();
    }

}
