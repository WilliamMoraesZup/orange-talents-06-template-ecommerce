package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

public enum StatusRetornoPagseguro {


    SUCESSO,
    ERRO;

    public StatusCompraTransacao retornaStatus() {
        return
                this.equals(SUCESSO) ? StatusCompraTransacao.SUCESSO : StatusCompraTransacao.FALHA;
    }

}