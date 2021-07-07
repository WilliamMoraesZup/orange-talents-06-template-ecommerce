package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto.FotoProduto;

import javax.validation.constraints.NotBlank;

public class DetalhesFotoRequest {

    @NotBlank
    private String link;


    public DetalhesFotoRequest(FotoProduto fotoProduto) {

        this.link = fotoProduto.getLink();

    }

    public String getLink() {
        return link;
    }
}
