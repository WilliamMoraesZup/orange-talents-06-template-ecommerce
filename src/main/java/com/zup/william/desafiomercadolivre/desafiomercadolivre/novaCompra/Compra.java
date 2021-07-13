package com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.RetornoCompra;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.Transacao;
import io.jsonwebtoken.lang.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


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

    @OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
    private Set<Transacao> transacaoSet = new HashSet<>();

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

    public String getGatewayLink() {
        return pagamento.getGatewayPagamento().gerarLink();
    }

    public Long getId() {
        return id;
    }

    public Produto getProdutoEscolhido() {
        return produtoEscolhido;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void adicionaNovaTentativa(@Valid RetornoCompra retornoCompra) {
        Transacao novaTransacao = retornoCompra.toTransacao(this);
        Assert.isTrue(!this.transacaoSet
                        .contains(novaTransacao),
                "Essa transação já foi processada");

        Assert.isTrue(pegaConcluidasComSucesso().isEmpty(),
                "Essa compra já foi concluida com sucessos");
        this.transacaoSet.add(novaTransacao);
    }

    private Set<Transacao> pegaConcluidasComSucesso() {
        Set<Transacao> concluidasComSucesso = this.transacaoSet.stream()
                .filter(Transacao::concluidaComSucesso)
                .collect(Collectors
                        .toSet());
        System.out.println(concluidasComSucesso);
        Assert.isTrue(concluidasComSucesso.size() <=1,
                "Tem mais de uma transacao concluida com sucesso para essa compra");

        return concluidasComSucesso;
    }

    public boolean processadaComSucesso() {
        return !pegaConcluidasComSucesso().isEmpty();
    }


    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", pagamento=" + pagamento +
                ", valor=" + valor +
                ", produtoEscolhido=" + produtoEscolhido +
                ", quantidade=" + quantidade +
                ", comprador=" + comprador +
                ", status=" + status +

                '}';
    }
}
