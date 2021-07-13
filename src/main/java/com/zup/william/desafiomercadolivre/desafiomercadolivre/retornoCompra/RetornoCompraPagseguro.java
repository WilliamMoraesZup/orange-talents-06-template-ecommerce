package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RetornoCompraPagseguro implements RetornoCompra {

    @NotNull
    private Long idTransacao;

    @NotNull
    private StatusRetornoPagseguro retorno;

    @Valid
    public RetornoCompraPagseguro(Long idTransacao, Long idPagamento, StatusRetornoPagseguro retorno) {
        this.idTransacao = idTransacao;
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "RetornoCompraPagseguro{" +
                "idCompra=" + idTransacao +

                ", retornoStatusPagamento=" + retorno +
                '}';
    }

    @Override
    public Transacao toTransacao(Compra compra) {

        Transacao transacao = new Transacao(idTransacao, retorno.retornaStatus(), compra);

        return transacao;
    }


}
