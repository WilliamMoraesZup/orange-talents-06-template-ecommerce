package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


public class CompraForm {


    @NotNull
    @Valid
    @Enumerated(EnumType.STRING)
    private GatewayEnum pagamento;

    @NotNull
    @Positive
    @Min(1)
    private int quantidade;

    @NotNull
    private Long idProduto;

    public int getQuantidade() {
        return quantidade;
    }

    public Compra toModel(UsuarioLogado usuarioLogado, EntityManager manager) {
        Produto produto = manager.find(Produto.class, idProduto);
        Assert.notNull(produto, "Produto não encontrado");

        Usuario usuario = manager.find(Usuario.class, usuarioLogado.getIdUsuarioLogado(manager));
        Assert.notNull(usuario, "Usuario não encontrado");

        BigDecimal valorTotal = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        Assert.notNull(valorTotal, "Erro ao calcula o valor");
        produto.abateEstoque(this);

        return new Compra(this.pagamento, valorTotal, produto, quantidade, usuario);
    }

    public CompraForm(@Valid GatewayEnum pagamento, int quantidade, Long idProduto) {
        this.pagamento = pagamento;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
}
