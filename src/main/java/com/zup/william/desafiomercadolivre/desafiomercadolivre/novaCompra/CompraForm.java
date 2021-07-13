package com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.springframework.validation.BindException;

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

    public Compra toModel(UsuarioLogado usuarioLogado, EntityManager manager) throws BindException {
        Produto produto = manager.find(Produto.class, idProduto);
        Assert.notNull(produto, "Produto não encontrado");

        Usuario usuario = manager.find(Usuario.class, usuarioLogado.getIdUsuarioLogado(manager));
        Assert.notNull(usuario, "Usuario não encontrado");

        if (produto.abateEstoque(quantidade)) {
            BigDecimal valorTotal = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
            Assert.notNull(valorTotal, "Erro ao calcular o valor");

            return new Compra(this.pagamento, valorTotal, produto, quantidade, usuario);
        }
        BindException problemaComEstoque = new BindException(this, "comprForm");
        problemaComEstoque.reject(null, "Não foi possivel realizar a compra por conta do estoque");

        throw problemaComEstoque;


    }

    public CompraForm(@Valid GatewayEnum pagamento, int quantidade, Long idProduto) {
        this.pagamento = pagamento;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
}
