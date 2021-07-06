package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Pergunta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private Instant momentoDeCriacao = Instant.now();

    @NotNull
    @ManyToOne
    private Usuario usuario;

    @NotNull
    @ManyToOne
    private Produto produto;

    public String getTitulo() {
        return titulo;
    }

    public Pergunta(String titulo, Usuario usuario, Produto produto) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.produto = produto;


    }

}
