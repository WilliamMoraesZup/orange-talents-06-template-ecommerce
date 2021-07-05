package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria.Categoria;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    @Min(0)
    private BigDecimal valor;

    @NotNull
    @Positive
    @Min(0)
    private int quantidade;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Instant instanteDeCadastro = Instant.now();

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Usuario usuarioVendedor;

    @OneToMany
    @NotNull
    @Size(min =  3)
    private List<Caracteristica> caracteristicasList = new ArrayList<>();

    public Produto(String nome, BigDecimal valor, int quantidade, String descricao, Categoria categoria, Usuario usuarioVendedor, List<Caracteristica> caracteristicasList) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuarioVendedor = usuarioVendedor;
        this.caracteristicasList = caracteristicasList ;
    }

    public Produto() {

    }
}
