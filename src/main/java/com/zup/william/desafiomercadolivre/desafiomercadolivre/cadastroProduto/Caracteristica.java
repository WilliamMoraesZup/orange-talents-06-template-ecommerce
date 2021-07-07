package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;


    public Caracteristica() {
    }

    public Caracteristica(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;
        System.out.println(nome);
        System.out.println(descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristica that = (Caracteristica) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }
}
