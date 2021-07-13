package com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra;


public class GatewayPagamentoPAYPAL implements GatewayPagamento {
    @Override
    public String gerarLink(  ) {


        return "paypal.com?buyerId={id}";
    }
}
