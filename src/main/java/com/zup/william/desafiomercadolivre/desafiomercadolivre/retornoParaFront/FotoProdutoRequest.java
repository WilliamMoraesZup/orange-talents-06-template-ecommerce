package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoParaFront;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto.FotoProduto;

import javax.validation.constraints.NotBlank;

public class FotoProdutoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String link;


    public FotoProdutoRequest(FotoProduto fotoProduto) {
        this.nome = fotoProduto.getNome();
        this.link = fotoProduto.getLink();

    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }
}
