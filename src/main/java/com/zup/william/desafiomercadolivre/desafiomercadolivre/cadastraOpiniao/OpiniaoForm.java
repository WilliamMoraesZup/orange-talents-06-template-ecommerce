package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import io.jsonwebtoken.lang.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

public class OpiniaoForm {


    @NotNull
    @Min(value = 1, message = "Nota: A nota deve ser entre 1 a 5")
    @Max(value = 5, message = "Nota: A nota deve ser entre 1 a 5")
    private int notaOpiniao;

    @NotBlank
    @Size(max = 500)
    private String descricao;


    private Long idUsuario;

    private Long idProduto;

    public Opiniao toModel(EntityManager manager, Long idProduto, Long idUsuario) {

        this.idProduto = idProduto;
        this.idUsuario = idUsuario;

        Produto produto = manager.find(Produto.class, this.idProduto);
        Assert.state(produto != null, "Produto não foi encontrado");

        Usuario usuario = manager.find(Usuario.class, this.idUsuario);
        Assert.state(usuario != null, "Usuário não foi encontrado");

        Assert.isTrue(!usuario.getLogin().equals(produto.getUsuarioVendedor().getLogin()), "O produto não pode pertencer ao próprio vendedor");

        OpiniaoENUM novaOpiniao = OpiniaoENUM.pegaOpiniaoPorValor(notaOpiniao);


        return new Opiniao(novaOpiniao, descricao, usuario, produto);
    }

    public OpiniaoForm(int opiniao, String descricao) {
        this.notaOpiniao = opiniao;
        this.descricao = descricao;

    }

}
