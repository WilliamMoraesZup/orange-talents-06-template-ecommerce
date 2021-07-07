package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Caracteristica;

import javax.validation.constraints.NotBlank;

public class DetalhesCaracteristica {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public DetalhesCaracteristica(Caracteristica caracteristica) {
        this.nome = caracteristica.getNome();
        this.descricao = caracteristica.getDescricao();
    }


}
