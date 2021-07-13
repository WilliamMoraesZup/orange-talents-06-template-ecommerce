package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;

public interface EventoCompraBemSucedida {
    void processa(Compra compra);
}
