package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

public enum StatusRetornoPaypal {

    ERRO(0),
    SUCESSO(1);

    private int codigoRetorno;

    StatusRetornoPaypal(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public StatusCompraTransacao retornaStatus() {
        return
                this.equals(SUCESSO) ? StatusCompraTransacao.SUCESSO : StatusCompraTransacao.FALHA;
    }
}
