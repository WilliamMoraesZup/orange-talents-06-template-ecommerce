package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos.EventoCompraBemSucedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EventosNovaCompra {

    @Autowired
    private Set<EventoCompraBemSucedida> eventoCompraBemSucedidaSet;

    public void processa(Compra compra) {

        if (compra.processadaComSucesso()) {
            eventoCompraBemSucedidaSet.forEach(e -> e.processa(compra));
        } else {
            // erros
        }
    }
}
