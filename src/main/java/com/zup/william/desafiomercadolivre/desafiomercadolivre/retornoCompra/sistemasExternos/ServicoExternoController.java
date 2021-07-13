package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ServicoExternoController {
    @PostMapping("/notas-fiscais")
    public ResponseEntity<?> emiteNF(@RequestBody @Valid NotaFiscalRequest request) {
        System.out.println("NOTA CRIADA: " + request);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/ranking-vendedores")
    public ResponseEntity<?> incluiRanking(@RequestBody @Valid RankingVendedoresRequest request) {
        System.out.println("RANKING ADICIONADO: " + request);
        return ResponseEntity.ok().build();
    }
}
