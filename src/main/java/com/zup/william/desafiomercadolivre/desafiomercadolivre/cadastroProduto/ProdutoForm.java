package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroCategoria.Categoria;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca.UsuarioLogado;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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


    private Long idVendedor;

    @NotNull
    @Size(min = 3)
    private Set<CaracteristicaForm> caracteristicas = new HashSet<>();

    public ProdutoForm(String nome, BigDecimal valor, int quantidade, String descricao, Long idCategoria, Set<CaracteristicaForm> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;

        this.caracteristicas = caracteristicas;
    }

    public Produto toModel(EntityManager manager, UsuarioLogado usuario) {
        System.out.println("USUARIO FOasdasdasdasdUND");
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Assert.isTrue(categoria != null, "Categoria " + idCategoria + " não foi encontrada");

        Query query = manager.createQuery("from Usuario where login=:pLogin");
        query.setParameter("pLogin", usuario.getUsername());
        List<Usuario> resultList = query.getResultList();
        Assert.isTrue(resultList.size() == 1, "Usuario " + usuario.getUsername() + " não foi encontrado");

       Set<Caracteristica> caracteristicaList = caracteristicas.stream().map(CaracteristicaForm::toModel).collect(Collectors.toSet());
        caracteristicaList.forEach(manager::persist);


        return new Produto(nome, valor, quantidade, descricao, categoria, resultList.get(0), caracteristicaList);

    }

    public Set<CaracteristicaForm> getCaracteristicas() {
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

                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
