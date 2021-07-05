package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;


import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
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

@RestController
@RequestMapping("/produto")
public class ProdutoController
{

    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    @Transactional
    public ResponseEntity<?> novoProduto(@RequestBody @Valid ProdutoForm form,  @AuthenticationPrincipal UsuarioLogado usuario) {
      Produto entidade = form.toModel(manager,usuario );
        System.out.println(form.getCaracteristicas());  manager.persist(entidade);



        return ResponseEntity.ok( ).build();
    }




}
