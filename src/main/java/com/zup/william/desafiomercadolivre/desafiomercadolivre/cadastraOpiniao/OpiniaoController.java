package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class OpiniaoController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping("/{idProduto}/opiniao")
    @Transactional
    public ResponseEntity<?> novaOpiniao(@RequestBody @Valid OpiniaoForm form, @PathVariable Long idProduto, @AuthenticationPrincipal UsuarioLogado usuarioLogado) {
        Opiniao opiniao = form.toModel(manager, idProduto, usuarioLogado.getIdUsuarioLogado(manager));
        Assert.notNull(opiniao,"Algo deu errado ao cadastrar a opiniao");
        manager.persist(opiniao);


        return ResponseEntity.ok(opiniao) ;
    }
}
