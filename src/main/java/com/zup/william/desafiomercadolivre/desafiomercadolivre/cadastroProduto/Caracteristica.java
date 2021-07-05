package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String nome;;
    @NotBlank
    private String descricao;

    public Caracteristica( String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;
    }
}
