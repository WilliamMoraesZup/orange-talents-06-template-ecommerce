package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    @ManyToOne
    private Produto produto;


    public Caracteristica( String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;
    }
}
