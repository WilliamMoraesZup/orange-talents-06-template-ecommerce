package com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Emails;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/compra")
public class NovaCompraController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private Emails emails;

    @PostMapping
    @Transactional
    public ResponseEntity<?> iniciandoCompra(@RequestBody @Valid CompraForm compraForm, @AuthenticationPrincipal UsuarioLogado usuarioLogado) {


        Compra novaCompra = compraForm.toModel(usuarioLogado, manager);
        Assert.notNull(novaCompra, "Houve um erro ao finalizar a compra");
        manager.persist(novaCompra);
        emails.novaCompra(novaCompra);

        URI location = URI.create(novaCompra.getRedirect( ));

        return   ResponseEntity.status(HttpStatus.FOUND).location(location) .build();
    }

}
