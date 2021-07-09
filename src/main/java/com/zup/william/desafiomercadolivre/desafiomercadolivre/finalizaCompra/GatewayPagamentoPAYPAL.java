package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

public class GatewayPagamentoPAYPAL implements GatewayPagamento {
    @Override
    public String gerarLink(Long codigo) {
        return String.format("paypal.com?buyerId=%d&redirectUrl={urlRetornoAppPosPagamento}", codigo);
    }
}
