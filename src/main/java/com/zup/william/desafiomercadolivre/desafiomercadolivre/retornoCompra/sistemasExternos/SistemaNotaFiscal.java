package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;
import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class SistemaNotaFiscal  implements EventoCompraBemSucedida {

@Override
    public void processa(Compra compra) {
    Assert.isTrue(compra.processadaComSucesso(),"A compra não foi concluida com sucesso ainda");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, ?> request = Map.of(
                "idCompra", compra.getId(),
                "idComprador", compra
                        .getComprador().getId());
        restTemplate.postForEntity("http://localhost:8080/notas-fiscais",
                request, String.class);
    }
}
