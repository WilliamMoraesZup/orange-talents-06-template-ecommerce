package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class FotoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String link;

    @NotNull
    @ManyToOne
    private Produto produto;

    public FotoProduto(   @NotBlank
                          @NotNull String nome,  @NotBlank
    @NotNull String link,  @NotBlank
    @NotNull @Valid Produto produto) {

        this.nome = nome;
        this.link = link;
        this.produto = produto;
    }

    public FotoProduto() {
    }

    @Override
    public String toString() {
        return "FotoProduto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", link='" + link + '\'' +
                ", produto=" + produto +
                '}';
    }
}
