package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foto")
public class FotoProdutoController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping(("/{idProduto}"))
    @Transactional
    public ResponseEntity<?> novaFoto(@RequestBody @Valid List<FotoProdutoForm> form,
                                      @PathVariable Long idProduto,
                                      @AuthenticationPrincipal UsuarioLogado usuario) {
        Produto produto = manager.find(Produto.class, idProduto);
        Assert.notNull(produto, "Produto não localizado");

        // VALIDA SE O USUARIO LOGADO É DONO DO PRODUTO INFORMADO

        if (!produto.getUsuarioVendedor().getLogin().equals(usuario.getUsername())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O produto informado não pertence ao usuário logado");
        }

        List<FotoProduto> collect = form.stream().map(e -> e.toModel(manager, idProduto)).collect(Collectors.toList());
        produto.setImagens(collect);


        return ResponseEntity.ok().build();
    }


}
