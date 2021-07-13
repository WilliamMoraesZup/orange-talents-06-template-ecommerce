package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;

public interface RetornoCompra {

    Transacao toTransacao(Compra compra);
}
