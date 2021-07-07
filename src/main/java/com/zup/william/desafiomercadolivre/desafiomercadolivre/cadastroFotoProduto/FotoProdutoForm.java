package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import io.jsonwebtoken.lang.Assert;
import org.hibernate.validator.constraints.URL;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class FotoProdutoForm {


    @NotBlank
    private String nome;

    @URL
    @NotBlank
    private String link;

    private Long idProduto;

    public FotoProdutoForm(String nome, String link, Long idProduto) {
        this.nome = nome;
        this.link = link;
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "FotoProdutoForm{" +
                "nome='" + nome + '\'' +
                ", link='" + link + '\'' +
                ", idProduto=" + idProduto +
                '}';
    }

    /**
     * @param manager
     * @return Produto deve obrigatoriamente pertencer ao usuario fornecido (logado)
     */
    public FotoProduto toModel(EntityManager manager, Long idProduto) {
        this.idProduto = idProduto;

        Produto produto = manager.find(Produto.class, idProduto);
        Assert.isTrue(produto != null, "Produto não encontrado");

        return new FotoProduto(nome, link, produto);

    }
}
