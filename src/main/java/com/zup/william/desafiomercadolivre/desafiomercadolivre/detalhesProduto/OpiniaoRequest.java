package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.Opiniao;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.OpiniaoENUM;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OpiniaoRequest {

    @NotNull
    private OpiniaoENUM opiniao;

    @NotBlank
    private String descricao;

    public OpiniaoRequest(Opiniao opiniao) {
        this.opiniao = opiniao.getOpiniao();
        this.descricao = opiniao.getDescricao();
    }

    public OpiniaoENUM getOpiniao() {
        return opiniao;
    }

    public String getDescricao() {
        return descricao;
    }
}
