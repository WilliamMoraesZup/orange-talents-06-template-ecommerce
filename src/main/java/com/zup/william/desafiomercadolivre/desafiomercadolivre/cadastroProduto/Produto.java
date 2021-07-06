package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.Opiniao;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria.Categoria;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto.FotoProduto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    @NotNull
    @Size(min = 3)
    private Set<Caracteristica> caracteristicasList = new HashSet<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<FotoProduto> imagens = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<Opiniao> opinioes;


    public Produto(String nome, BigDecimal valor, int quantidade, String descricao, Categoria categoria, Usuario usuarioVendedor, Set<Caracteristica> caracteristicasList) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuarioVendedor = usuarioVendedor;
        this.caracteristicasList = caracteristicasList;
    }

    public Produto() {
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setImagens(List<FotoProduto> imagens) {
        System.out.println(imagens);
        this.imagens.addAll(imagens);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", instanteDeCadastro=" + instanteDeCadastro +
                ", categoria=" + categoria +
                ", usuarioVendedor=" + usuarioVendedor +
                ", caracteristicasList=" + caracteristicasList +
                ", imagens=" + imagens +
                '}';
    }
}
