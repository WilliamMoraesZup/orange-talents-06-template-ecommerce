package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria.Categoria;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoForm {
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
    private Long idCategoria;

    @NotNull
    private Long idVendedor;

    @NotNull
    @Size(min = 3)
    private List<CaracteristicaForm> caracteristicas = new ArrayList<>();

    public ProdutoForm(String nome, BigDecimal valor, int quantidade, String descricao, Long idCategoria,   List<CaracteristicaForm> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;

        this.caracteristicas = caracteristicas;
    }

    public Produto toModel(EntityManager manager, UsuarioLogado usuario) {

        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Assert.isTrue(categoria != null, "Categoria " + idCategoria + " não foi encontrada");


        Usuario vendedor = manager.find(Usuario.class, idVendedor);
        Assert.isTrue(vendedor != null, "Usuario " + idVendedor + " não foi encontrado");


        List<Caracteristica> caracteristicaList = caracteristicas.stream().map(CaracteristicaForm::toModel).collect(Collectors.toList());
        caracteristicaList  .forEach(manager::persist);



        return new Produto(nome, valor, quantidade, descricao, categoria, vendedor, caracteristicaList);

    }

    public List<CaracteristicaForm> getCaracteristicas() {
        return caracteristicas;
    }

    @Override
    public String toString() {
        return "ProdutoForm{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", idVendedor=" + idVendedor +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
