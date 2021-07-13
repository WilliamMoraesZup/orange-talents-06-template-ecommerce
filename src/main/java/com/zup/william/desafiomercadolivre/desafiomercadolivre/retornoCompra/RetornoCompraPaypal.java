package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class RetornoCompraPaypal implements RetornoCompra {

    @NotNull
    private Long idTransacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusRetornoPaypal retorno;

    public RetornoCompraPaypal(Long idTransacao, StatusRetornoPaypal retorno) {
        this.idTransacao = idTransacao;
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "RetornoCompraPaypal{" +
                "idCompra=" + idTransacao +

                ", retorno=" + retorno +
                '}';
    }


    @Override
    public Transacao toTransacao(Compra compra) {
        return new Transacao(idTransacao, retorno.retornaStatus(), compra);
    }
}
