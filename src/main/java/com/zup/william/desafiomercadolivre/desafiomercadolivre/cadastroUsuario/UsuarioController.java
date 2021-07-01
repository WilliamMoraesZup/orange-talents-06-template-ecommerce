package com.william.mercadolivre.mercadolivre.cadastroUsuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novoUsuario(@RequestBody @Valid UsuarioForm usuarioForm) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Usuario novoUsuario = usuarioForm.toModel();
        manager.persist(novoUsuario);


        return ResponseEntity.ok().build();


    }


}
