package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoParaFront;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import io.jsonwebtoken.lang.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class FrontController {
    @PersistenceContext
    private EntityManager manager;


    @GetMapping("/produto/{id}")
    public ResponseEntity<?> dadosProduto(@PathVariable Long id) {
        Produto produto = manager.find(Produto.class, id);
        Assert.notNull(produto, "O produto não foi encontrado no banco de dados");

        ProdutoFrontRequest produtoProFront = new ProdutoFrontRequest(produto, manager);
        System.out.println(produtoProFront);
        return ResponseEntity.ok(produtoProFront) ;
    }
}
