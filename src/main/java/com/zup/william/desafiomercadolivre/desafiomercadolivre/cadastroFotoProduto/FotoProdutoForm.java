package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class FotoProdutoForm {


    @NotBlank
    private String nome;

    @NotBlank @URL
    private String link;

    private Long idProduto;

    public FotoProdutoForm(String nome, String link) {
        this.nome = nome;
        this.link = link;

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
