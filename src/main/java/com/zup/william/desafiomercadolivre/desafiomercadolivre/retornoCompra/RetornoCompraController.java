package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos.SistemaNotaFiscal;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class RetornoCompraController {
    @Autowired
    private SistemaNotaFiscal nf;

    @Autowired
    private EventosNovaCompra eventosNovaCompra;

    @PersistenceContext
    private EntityManager manager;

    @NotNull
    private ResponseEntity<?> validandoRespostaCompra(RetornoCompra form, long id) {
        Compra compra = manager.find(Compra.class, id);
        compra.adicionaNovaTentativa(form);
        manager.merge(compra);
        eventosNovaCompra.processa(compra);


        return ResponseEntity.ok().build();
    }


    @PostMapping("/pagseguro/{id}")
    @Transactional
    public ResponseEntity<?> retornoPagseguro(@RequestBody @Valid RetornoCompraPagseguro form, @PathVariable long id) {
        return validandoRespostaCompra(form, id);
    }


    @PostMapping("/paypal/{id}")
    @Transactional
    public ResponseEntity<?> retornoPaypal(@RequestBody @Valid RetornoCompraPaypal form, @PathVariable long id) {
        return validandoRespostaCompra(form, id);
    }

}
