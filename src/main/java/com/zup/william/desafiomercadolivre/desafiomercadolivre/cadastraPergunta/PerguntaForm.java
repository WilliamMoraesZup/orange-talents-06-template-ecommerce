package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import io.jsonwebtoken.lang.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class PerguntaForm {


    @NotBlank
    private String titulo;

    public PerguntaForm(String titulo) {
        this.titulo = titulo;
    }

    public PerguntaForm() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pergunta toModel(EntityManager manager, Long idUsuario, Long idProduto) {

        Produto produto = manager.find(Produto.class, idProduto);
        Usuario usuario = manager.find(Usuario.class, idUsuario);

        Assert.state(produto != null, "Produto não foi encontrado");
        Assert.state(usuario != null, "Usuário não foi encontrado");

        return new Pergunta(titulo, usuario, produto);


    }
}