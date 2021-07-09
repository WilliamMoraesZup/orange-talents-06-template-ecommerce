package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

public enum GatewayEnum {
    PAGSEGURO(new GatewayPagamentoPAGSEGURO()),
    PAYPAL(new GatewayPagamentoPAYPAL());

    private GatewayPagamento gatewayPagamento;

    public GatewayPagamento getGatewayPagamento() {
        return gatewayPagamento;
    }

    GatewayEnum(GatewayPagamento gatewayPagamento) {
        this.gatewayPagamento = gatewayPagamento;
    }


}
