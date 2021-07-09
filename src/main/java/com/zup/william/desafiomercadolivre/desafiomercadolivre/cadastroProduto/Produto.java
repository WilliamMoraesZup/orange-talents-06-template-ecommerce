package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.Opiniao;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria.Categoria;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroFotoProduto.FotoProduto;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.finalizaCompra.CompraForm;
import io.jsonwebtoken.lang.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;


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
    // @Positive
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

    @Size(min = 3)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Caracteristica> caracteristicasList = new HashSet<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private Set<FotoProduto> imagens = new HashSet<>();

    @OneToMany(mappedBy = "produto")
    @OrderBy("titulo asc")
    private SortedSet<Pergunta> perguntas = new TreeSet<>();


    @OneToMany(mappedBy = "produto")
    private Set<Opiniao> opinioes = new HashSet<>();


    public Produto(String nome, BigDecimal valor, int quantidade, String descricao, Categoria categoria, Usuario usuarioVendedor, Set<Caracteristica> caracteristicasList) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuarioVendedor = usuarioVendedor;
        this.caracteristicasList.addAll(caracteristicasList);
    }

    @Deprecated
    public Produto() {
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public OpinoesAuxiliar getOpinioes() {
        return new OpinoesAuxiliar(this.opinioes);
    }

    public <T> Set<T> mapeiaCaracteristicas(Function<Caracteristica, T> funcaoMapeadora) {

        return this.caracteristicasList.stream()
                .map(funcaoMapeadora)
                .collect(Collectors.toSet());
    }

    public <T> Set<T> mapeiaImagens(Function<FotoProduto, T> funcaoMapeadora) {
        return this.imagens.stream()
                .map(funcaoMapeadora)
                .collect(Collectors.toSet());
    }

    public <T extends Comparable<T>> SortedSet<T> mapeiaPerguntas(Function<Pergunta, T> funcaoMapeadora) {
        return this.perguntas.stream()
                .map(funcaoMapeadora)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public int abateEstoque(CompraForm compraForm) {
        Assert.isTrue(this.quantidade > 0, "Produto não possui unidades em estoque");
        Assert.isTrue(compraForm.getQuantidade() <= this.quantidade, "O produto não possui quantidade suficiente");

        return this
                .quantidade -= compraForm.getQuantidade();
    }

}


