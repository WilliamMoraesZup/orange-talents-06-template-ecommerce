package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

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


    @Size(min = 3)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Caracteristica> caracteristicasList = new HashSet<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<FotoProduto> imagens = new ArrayList<>();

//    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
//    private List<Opiniao> opinioes;


    public Produto(String nome, BigDecimal valor, int quantidade, String descricao, Categoria categoria, Usuario usuarioVendedor, Set<Caracteristica> caracteristicasList) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuarioVendedor = usuarioVendedor;
        this.caracteristicasList.addAll(caracteristicasList);
    }

    public Produto() {
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setImagens(List<FotoProduto> imagensRecebidsa) {

        this.imagens.addAll(imagensRecebidsa);
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

    public Set<Caracteristica> getCaracteristicasList() {
        return caracteristicasList;
    }

    public List<FotoProduto> getImagens() {
        return imagens;
    }
}
