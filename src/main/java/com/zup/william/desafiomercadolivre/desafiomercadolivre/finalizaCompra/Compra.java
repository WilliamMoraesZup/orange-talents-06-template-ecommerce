package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Valid
    private GatewayEnum pagamento;

    @NotNull
    private BigDecimal valor;

    @NotNull
    @ManyToOne
    private Produto produtoEscolhido;

    @NotNull
    @Positive
    @Min(1)
    private int quantidade;

    @NotNull
    @ManyToOne
    private Usuario comprador;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.INICIADA;

    @Deprecated
    public Compra() {
    }

    public Compra(GatewayEnum pagamento, BigDecimal valor, Produto produtoEscolhido, int quantidade, Usuario comprador) {
        this.pagamento = pagamento;
        this.valor = valor;
        this.produtoEscolhido = produtoEscolhido;
        this.quantidade = quantidade;
        this.comprador = comprador;
    }

    public String getRedirect() {
        return pagamento.getGatewayPagamento().gerarLink(this.id);
    }

    public Produto getProdutoEscolhido() {
        return produtoEscolhido;
    }

    public Usuario getComprador() {
        return comprador;
    }
}
