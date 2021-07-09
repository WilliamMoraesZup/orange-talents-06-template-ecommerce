package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PerguntaController {


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Emails email;

    @PostMapping("/produto/{idProduto}/pergunta")
    @Transactional
    public ResponseEntity<?> novaPergunta(@RequestBody @Valid PerguntaForm form, @PathVariable Long idProduto, @AuthenticationPrincipal UsuarioLogado usuarioLogado) {

        Pergunta pergunta = form.toModel(manager, usuarioLogado.getIdUsuarioLogado(manager), idProduto);
        Assert.notNull(pergunta, "Houve algum erro ao criar a pergunta");

        manager.persist(pergunta);
        email.novaPergunta(pergunta);

        return ResponseEntity.ok().build();
    }

}
