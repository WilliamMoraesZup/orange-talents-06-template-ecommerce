package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class GatewayPagamentoPAGSEGURO implements GatewayPagamento {
    @Override
    public String gerarLink(Long codigo) {
        String format = String.format("pagseguro.com?returnId=%d&redirectUrl={urlRetornoAppPosPagamento}", codigo);
        return format;
    }
}
