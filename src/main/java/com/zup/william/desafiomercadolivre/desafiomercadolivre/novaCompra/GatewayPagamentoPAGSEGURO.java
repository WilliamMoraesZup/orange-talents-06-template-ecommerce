package com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra;

public class GatewayPagamentoPAGSEGURO implements GatewayPagamento {
    @Override
    public String gerarLink( ) {

        return "pagseguro.com?returnId={id}" ;
    }
}
