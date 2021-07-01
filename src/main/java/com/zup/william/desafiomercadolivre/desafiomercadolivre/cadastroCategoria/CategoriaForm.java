package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado.DeveSerUnico;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @DeveSerUnico(value = "nome", classe = Categoria.class)
    private String nome;

    private Long categoriaMaeId;

    public Categoria toModel(EntityManager manager) {

        if (categoriaMaeId != null) {
            Categoria categoria = manager.find(Categoria.class, categoriaMaeId);
            Assert.notNull(categoria, "A categoria não foi encontrada");
            return new Categoria(nome, categoria);
        }
        return new Categoria(nome);
    }

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public CategoriaForm(String nome, Long categoriaMaeId) {
        this.nome = nome;
        this.categoriaMaeId = categoriaMaeId;
    }
}

