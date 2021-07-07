package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opiniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private OpiniaoENUM opiniao;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    @NotNull
    @ManyToOne
    private Produto produto;

    public Opiniao(OpiniaoENUM opiniao, String descricao, Usuario usuario, Produto produto) {
        this.opiniao = opiniao;
        this.descricao = descricao;
        this.usuario = usuario;
        this.produto = produto;



    }

    public Opiniao() {
    }

    @Override
    public String toString() {
        return "Opiniao{" +
                "id=" + id +
                ", opiniao=" + opiniao +
                ", descricao='" + descricao + '\'' +
                ", usuario=" + usuario +
                ", produto=" + produto +
                '}';
    }

    public OpiniaoENUM getOpiniao() {
        return opiniao;
    }

    public String getDescricao() {
        return descricao;
    }
}
